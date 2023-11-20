const plays = require("./data/plays.json");
const invoices = require("./data/invoices.json");

function getThisAmmountByPlayType(play){
  let thisAmount = 0;
  switch (play.type) {
    case "tragedy":
      thisAmount = 40000;
      if (perf.audience > 30) {
        thisAmount += 1000 * (perf.audience - 30);
      }
      break;
    case "comedy":
      thisAmount = 30000;
      if (perf.audience > 20) {
        thisAmount += 10000 + 500 * (perf.audience - 20);
      }
      thisAmount += 300 * perf.audience;
      break;
    default:
        throw new Error(`unknown type: ${play.type}`);
    }
    return thisAmount
}

function getCurrencyFormat(){
    return new Intl.NumberFormat("en-US",
    { style: "currency", currency: "USD",
      minimumFractionDigits: 2 }).format;
}

function statement (invoice, plays) {
  let totalAmount = 0;
  let volumeCredits = 0;
  let result = `Statement for ${invoice.customer}\n`;

  const format = getCurrencyFormat();

  for (let perf of invoice.performances) {
    const play = plays[perf.playID];
    const thisAmount = getThisAmmountByPlayType(play);
    addVolumeCredits(play.type, perf.audience);
    addItem(`  ${play.name}: ${format(thisAmount/100)} (${perf.audience} seats)\n`);
    totalAmount += thisAmount;
  }

  addItem(`Amount owed is ${format(totalAmount/100)}\n`);
  addItem(`You earned ${volumeCredits} credits\n`);
  
  return result;

  function addVolumeCredits(type, audience){
    volumeCredits += Math.max(perf.audience - 30, 0) + (type === "comedy" ? Math.floor(audience / 5) : 0);
  }

  function addItem(item){
    result += item;
  }
}

console.log(statement(invoices[0], plays));