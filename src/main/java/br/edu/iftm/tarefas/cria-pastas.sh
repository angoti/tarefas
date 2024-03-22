#!/bin/bash

# Lista de nomes de pastas a serem criadas
pastas=("controller" "domain" "repository" "service")

# Loop através da lista de pastas
for pasta in "${pastas[@]}"
do
   mkdir $pasta
done
