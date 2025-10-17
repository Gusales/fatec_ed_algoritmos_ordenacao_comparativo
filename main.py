import subprocess
import os
import glob
import re
import sys

print("Compilando arquivos java")
current_directory = os.getcwd()

java_files = glob.glob(os.path.join(current_directory, "vetor", "*.java"))
if not java_files:
    raise Exception("Nenhum arquivo .java encontrado em ./vetor. Verifique o caminho.")

print("Arquivos encontrados para compilação:")
for f in java_files:
    print("  ", f)

print("Executando compilação do arquivo")
result_compile = subprocess.run(['javac'] + java_files, capture_output=True)

print(f"Resultado da compilação: {result_compile.returncode}")
if result_compile.returncode == 0:
    print("Executando classe Main")
    main_file_class = os.path.join(current_directory, "vetor", "Main")
    print(f"Caminho do arquivo Main.class: {main_file_class}")

    print("Executando programa java:")
    execute_main_class = subprocess.run(['java', '-cp', './vetor', 'Main'], capture_output=True, text=True)
    print(f"Resultado da compilação: {execute_main_class.returncode}")

    if execute_main_class.returncode == 0:
        print(f"Programa executado com sucesso! Logs de saída:\n{execute_main_class.stdout}")

        message_hello_worlds = execute_main_class.stdout.splitlines()
    else:
        raise Exception(f"Falha ao executar programa Java!\n{execute_main_class.stderr}")
else:
    raise Exception(f"Falha ao copilar arquivo Main.java!\n{result_compile.stderr}")