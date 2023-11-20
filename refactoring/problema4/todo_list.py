def print_menu():
    print('-------------------------')
    print('1. Ver tareas')
    print('2. Agregar una tarea')
    print('3. Eliminar una tarea')
    print('4. Salir')
    print('-------------------------')

def obtener_tareas_de_archivo(file_path):
    try:
        file = open(file_path, 'r')
        lines = file.readlines()
        file.close()
    except FileNotFoundError:
        print('No existe el archivo todo.txt')
        lines = []
    return [line.rstrip() for line in lines]

def imprimir_tareas(tareas):
    print('-------------------------')
    print('Tareas:')
    for i, tarea in enumerate(tareas):
        print('{}. {}'.format(i + 1, tarea))

def agregar_tareas(nueva_tarea, tareas):
    tareas.append(nueva_tarea)
    print('Tarea agregada')

def eliminar_tarea(tarea_a_eliminar, tareas):
    if tarea_a_eliminar.isdigit() and (0 < int(tarea_a_eliminar) <= len(tareas)):
        tareas.pop(int(tarea_a_eliminar) - 1)
        print('Tarea eliminada')
    else: 
        print('No existe la tarea')

def actualizar_archivo(file_path, tareas):
    file = open(file_path, 'w')
    for tarea in tareas:
        file.write(tarea + '\n')
    file.close()


def todo_list():
    file_path = "./data/todo.txt"

    tareas = obtener_tareas_de_archivo(file_path)

    print('Bienvenido a su lista de tareas. Estas son sus opciones:')

    while True:
        print_menu()

        opcion = input('Ingrese una opcion: ')

        if opcion == '1':
            imprimir_tareas(tareas)
        elif opcion == '2':
            nueva_tarea = input('Ingrese la tarea: ')
            agregar_tareas(nueva_tarea, tareas)
        elif opcion == '3':
            tarea_a_eliminiar = input('Ingrese la tarea a eliminar: ')
            eliminar_tarea(tarea_a_eliminiar, tareas)
        elif opcion == '4':
            print('Adios')
            break

    actualizar_archivo(file_path, tareas)
    

if __name__ == '__main__':
    todo_list()