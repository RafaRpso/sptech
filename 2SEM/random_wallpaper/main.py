
import os
import os.path
import random

file = open('path.txt', 'r')
text = file.read()


def write_all(wall):
    with open('history.txt', 'a') as f:
        f.write(f""" \n {wall} ; \n """)


def verify_path():

    if len(text) == 0:
        return False
    else:
        return True


def choose_one_sort(arr):
    rand_img = arr[random.randint(0, len(arr))]
    return rand_img


def change_wall(file, path):
    os.system(f'feh {path}/{file} --bg-fill')


def verifica_validade_path(path):
    is_path = os.popen(f"cd {path} && pwd").read()

    if is_path == "":
        return False
    return True


def validacao_path_config(valid_path, path):
    if (valid_path):
        return enter_dir(path)
    else:
        print("Ocorreu  um erro: O arquivo não foi encontrado")


def enter_dir(path):
    return os.popen(f'ls {path}').read()


def main():

    if verify_path():
        path = str(text).strip()
    else:

        print("Insira o diretório dos wallpapers")
        path = input()
        with open('path.txt', 'w') as f:
            f.write(path)
    files = validacao_path_config(
        verifica_validade_path(path), path).split('\n')

    random_wall = choose_one_sort(files)
    change_wall(random_wall, path)

    write_all(random_wall)


main()
