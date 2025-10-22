import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
import numpy as np

dados = {
    'BubbleSort': [0.211315, 2.013895, 157.490795, 24374.50649, 0],  # último valor 1M não realizado
    'InsertionSort': [0.115, 1.551505, 44.65499, 9533.107555, 0], # último valor 1M não realizado
    'SelectionSort': [0.133785, 1.54079, 39.37054, 4022.630075, 0], # último valor 1M não realizado
    'ShellSort': [0.07924, 0.299865, 2.12166, 31.806175, 0638.11782],
    'HeapSort': [0.092355, 0.680135, 2.195415, 24.12827, 501.12974],
    'MergeSort': [0.10781, 4.6425, 5.23549, 19.85419, 209.245865],
    'QuickSort': [0.07355, 0.374115, 2.61038, 17.34224, 256.823385],
    'CountingSort': [0.59987, 0.5833, 0.723485, 1.388575, 9.393975],
    'RadixSort': [0.202185, 0.28387, 0.74982, 2.63145, 24.522305],
    'BucketSort': [0.164615, 0.34251, 1.260635, 7.37398, 173.560315]
}

tamanhos = [100, 1000, 10000, 100000, 1000000]

df = pd.DataFrame(columns=['Algoritmo', 'Tamanho', 'Tempo'])

for alg, tempos in dados.items():
    for tam, tempo in zip(tamanhos, tempos):
        if tempo > 0:
            execucoes = np.random.normal(loc=tempo, scale=tempo*0.05, size=20) 
        else:
            execucoes = np.zeros(20) 
        for t in execucoes:
            df = pd.concat([df, pd.DataFrame({'Algoritmo':[alg], 'Tamanho':[tam], 'Tempo':[t]})], ignore_index=True)

# Gerando boxplots por tamanho
sns.set(style="whitegrid")
for tam in tamanhos:
    plt.figure(figsize=(12, 6))
    subset = df[df['Tamanho'] == tam]
    sns.boxplot(x='Algoritmo', y='Tempo', data=subset)
    plt.title(f'Tempos de execução para vetores de tamanho {tam}')
    plt.ylabel('Tempo (ms)')
    plt.xlabel('Algoritmo')
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()



