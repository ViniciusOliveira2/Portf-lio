#include <stdio.h>
#include <stdlib.h>

int recebe(int *ptr, int tamanho);
int ordenar(int *ptr, int tamanho);
int* uniao(int *x1, int *x2, int n1, int n2, int* qtd);

int main(){
	int tam1, tam2, tam3;
	int *vetor1, *vetor2, *vetor3, *qtd = &tam3;

	//Iniciando vetor1
	
	printf("Informe o tamanho do vetor 1: ");
	scanf("%d",& tam1);
	printf("\n");
		
	vetor1 = (int *) malloc(tam1 * sizeof(int));
	
	if(!vetor1)
	{
		printf("Erro na alocacao!\n");
		return 0;
	}
	
	recebe(vetor1, tam1);
	ordenar(vetor1, tam1);
	printf("\n");

	//Iniciando vetor2
	
	printf("Informe o tamanho do vetor 2: ");
	scanf("%d",& tam2);
	printf("\n");
		
	vetor2 = (int *) malloc(tam2 * sizeof(int));
	
	if(!vetor2)
	{
		printf("Erro na alocacao!\n");
		return 0;
	}
	
	recebe(vetor2, tam2);
	ordenar(vetor2, tam2);
	printf("\n");
		
	//União do vetor1 com vetor2
	
	vetor3 = uniao(vetor1, vetor2, tam1, tam2, qtd);
	
	if(!vetor3)
	{
		printf("Erro na alocacao!\n");
		return 0;
	}	
	
	printf("O tamanho do vetor 3: %d\n", *qtd);
	
	free(vetor1);
	free(vetor2);
	free(vetor3);
	
	return 0;
}

int recebe(int *ptr, int tamanho)
{
	for(int i = 0; i < tamanho; i++)
	{
		printf("Digite um valor: ");
		scanf("%d", &ptr[i]);
	}
}

int ordenar(int *ptr, int tamanho){
	int i, j, aux;
	
    for(i = 0; i < tamanho; i++){
        for(j = i + 1; j < tamanho; j++){
            if(ptr[i] > ptr[j]){
                aux = ptr[i];
                ptr[i] = ptr[j];
                ptr[j] = aux;
            }
        }
    }
}

int* uniao(int *x1, int *x2, int n1, int n2, int* qtd){	
	int* x3 = (int *) malloc((n1 + n2) * sizeof(int));
	int repete, cont = 0;
	
	//Inserindo vetor1 no vetor3
	for(int x = 0; x < n1; x++){
		repete = 0;
		
		for(int y = 0; y < (cont); y++){
			if(x1[x] == x3[y]) repete++;
		}
		
		if(repete != 1){
			x3[cont] = x1[x];
			cont++;
		}
	}
	
	//Inserindo vetor2 no vetor3
	for(int x = 0; x < n2; x++){
		repete = 0;
		
		for(int y = 0; y < (cont); y++){
			if(x2[x] == x3[y]) repete = 1;
		}
		
		if(repete != 1){
			x3[cont] = x2[x];
			cont++;
		}
	}
	
	ordenar(x3, cont);
	*qtd = cont;
	
	return x3;
}
