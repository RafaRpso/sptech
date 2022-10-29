from password import Gerador
f = open("pass.txt", 'a')


def main():
    g = Gerador(12, 2)
    new_pass = g.create_pass()
    f.write(new_pass + "\n")


main()
