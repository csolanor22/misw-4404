# Tenemos un archivo de logs que contiene errores, warnings y mensajes de información.
# Cada linea del archivo comienza con una letra que indica el tipo de log. Si
# comienza con 'E' es un error, si comienza con 'W' es un warning y si comienza
# con 'I' es de información. Luego de la letra, se encuentra un entero que
# indica el tiempo del log, y luego el mensaje del log. Excepto en el caso de
# los errores, que luego del tipo se encuentra un entero que indica la severidad
# del error. Por ejemplo:

# I 147 iniciando el programa
# W 604 this is not a warning
# E 2 4562 unexpected token

# Queremos separar los errores mas severos (con severidad mayor a 50) y ordenarlos
# cronologicamente. Despues, queremos imprimirlos a la pantalla.

import os

def get_error_lines(error_file_path):
    with open(error_file_path, 'r') as f:
        lineas = f.readlines()
        return [line.rstrip().split(' ') for line in lineas]

def es_error(linea):
    return linea[0] == 'E'

def es_de_severidad_mayor_a_50(linea):
    return int(linea[1]) > 50

def ordenar_errores(errores):
    errores.sort(key=lambda x: int(x[2]))

def imprimir_errores(errores):
    for error in errores:
        print(' '.join(error))

def organizar():
    error_file_path = './refactoring/problema2/data/error.log'
    errores = []
    lineas = get_error_lines(error_file_path)
    for linea in lineas:
        if es_error(linea) and es_de_severidad_mayor_a_50(linea):
            errores.append(linea)
    ordenar_errores(errores)
    imprimir_errores(errores)

def main():
    organizar()

if __name__ == '__main__':
    main()
