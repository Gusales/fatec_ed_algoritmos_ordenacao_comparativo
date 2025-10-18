import subprocess
import os
import glob
import csv

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

complete_results = []

if result_compile.returncode == 0:
    sizes = [2000, 4000, 8000, 12000, 16000, 0]
    inputs = "\n".join(str(s) for s in sizes) + "\n"

    for i in range(0, 15):
        print("--------------------------------------------------------------------------------")
        print("Executando classe Main")
        main_file_class = os.path.join(current_directory, "vetor", "Main")
        print(f"Caminho do arquivo Main.class: {main_file_class}")

        print("Executando programa java:")
        execute_main_class = subprocess.run(
            ['java', '-cp', './vetor', 'Main'],
            input=inputs,
            capture_output=True,
            text=True
        )
        print(f"Resultado da compilação: {execute_main_class.returncode}")
        if execute_main_class.returncode == 0:
            raw_items = {
                "i": i - 4,
            }
            if i > 4:
                logs = execute_main_class.stdout.splitlines()
                for log in logs:
                    results = log.split(":")
                    if results[0].strip() == "capacidade":
                        raw_items["size"] = int(results[1].strip())
                    sort_algorithms = ["InsertionSort", "SelectionSort", "BubbleSort", "QuickSort"]
                    if any(algorithm in results for algorithm in sort_algorithms):
                        complete_results.append({
                            **raw_items,
                            "Algoritmo": results[0],
                            "time": results[1].strip()
                        })
        else:
            raise Exception(f"Falha ao executar programa Java!\n{execute_main_class.stderr}")
else:
    raise Exception(f"Falha ao copilar arquivo Main.java!\n{result_compile.stderr}")


print(complete_results)
columns_keys = complete_results[0].keys()
csv_output_file = "output.csv"

with open(csv_output_file, mode="w", newline="", encoding="utf-8") as csv_file:
    writer = csv.writer(csv_file)
    writer.writerow(['Num. Execução', 'Tamanho', 'Algoritmo', 'Tempo (MS)'])

    for item in complete_results:
        if item["size"] != 0:
            writer.writerow([item["i"], item["size"], item["Algoritmo"], item["time"]])


print(len(complete_results))
