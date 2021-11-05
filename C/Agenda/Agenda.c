#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <stdlib.h>

//TRABALHO VINICIUS FOGAÇA & VINICIUS ANTONY

typedef struct{
	int codigo;
	char nome[50];
	char telefone[20];
	char endereco[50];
	char email[50];
} contato;

void exibirMenu();
int quantidade(int* qtn);
contato* cadastrar(int qtn, int cadastros, contato* ptr);
void pesquisarEmail(contato* ptr, int cadastros);
void pesquisarNome(contato* ptr, int cadastros);
contato* alterarDados(contato* ptr, int cadastros);
contato* excluirContatos(contato* ptr,int* cadastros);

int main(){
	int menu = 0, cadastros = 0, qtn = 0;
	contato* ptr = (contato *) malloc(sizeof(contato*) * 0);
	
	setlocale(LC_ALL,"");
	
	while(menu != 6){
		exibirMenu();
		
		printf("Informe uma Opção: ");
		scanf("%d",& menu);
		
		system("cls");
		
		switch(menu){
			case 1:
				cadastros += quantidade(&qtn);
				ptr = cadastrar(qtn, cadastros, ptr);
				break;
			case 2:
				pesquisarEmail(ptr, cadastros);
				break;
			case 3:
				pesquisarNome(ptr, cadastros);
				break;
			case 4:
				ptr = alterarDados(ptr, cadastros);
				break;
			case 5:
				ptr = excluirContatos(ptr,& cadastros);
				break;
			case 6:
				break;
			default:
				printf("\nValor Inválido!!!");
		}
		
		system("cls");
	}
		
	free(ptr);
	return 0;
}
	

void exibirMenu(){
	printf("1. Cadastrar Contatos\n2. Pesquisar Contato por E-mail\n");
	printf("3. Pesquisar Contato pelo Nome\n4. Alterar Dados de um Contato\n");
	printf("5. Excluir um Contato pelo Código\n6. Sair\n\n");
}

int quantidade(int* qtn){
	printf("Informe Quantos Contatos Deseja Salvar: ");
	scanf("%d", qtn);

	return *qtn;
}

contato* cadastrar(int qtn, int cadastros, contato* ptr){
	ptr = realloc(ptr, (contato *) malloc(sizeof(contato*) * cadastros));
	
	for(int i = (cadastros - qtn); i < cadastros; i++){
		system("cls");
		fflush(stdin);
		
		ptr[i].codigo = i + 1;
		printf("Código: %d\n", ptr[i].codigo);
		
		printf("Informe o Nome: ");
		gets(ptr[i].nome);
		
		printf("Informe o Fone: ");
		gets(ptr[i].telefone);
		
		printf("Informe o Endereço: ");
		gets(ptr[i].endereco);
		
		printf("Informe o E-mail: ");
		gets(ptr[i].email);
	}
	
	return ptr;
}

void pesquisarEmail(contato* ptr, int cadastros){
	char email[50];
	int controle;
	
	printf("Informe o E-mail Procurado: ");
	fflush(stdin);
	gets(email);
	
	controle = 0;
	
	for(int i = 0; i < cadastros; i++){
		if(strcmp(email, ptr[i].email) == 0){
			printf("\n|Código: %d\n|Nome: %s\n|Fone: %s\n|Endereço: %s\n|E-mail: %s\n\n", ptr[i].codigo, ptr[i].nome, ptr[i].telefone, ptr[i].endereco, ptr[i].email);
			controle = 1;
		}
	}
	
	if(controle == 0){
		printf("\nE-mail não Cadastrado\n\n");
	}
	
	system("pause");
}

void pesquisarNome(contato* ptr, int cadastros){
	char nome[50];
	int controle;
	
	printf("Informe o Nome Procurado: ");
	fflush(stdin);
	gets(nome);
	
	controle = 0;
	
	for(int i = 0; i < cadastros; i++){
		if(strcmp(nome, ptr[i].nome) == 0){
			printf("\n|Código: %d\n|Nome: %s\n|Fone: %s\n|Endereço: %s\n|E-mail: %s\n\n", ptr[i].codigo, ptr[i].nome, ptr[i].telefone, ptr[i].endereco, ptr[i].email);
			controle = 1;
		}
	}
	
	if(controle == 0){
		printf("\nNome não Cadastrado\n\n");
	}
	
	system("pause");
}

contato* alterarDados(contato* ptr,int cadastros){
	int codigo, valI, controle = 0, conferir;
	
	system("cls");
	printf("Informe o Código do Contato que Deseja Editar: ");
	fflush(stdin);
	scanf("%d",& codigo);
	
	for(int i = 0; i < cadastros; i ++){
		if(codigo == ptr[i].codigo){
			printf("\n|Código: %d\n|Nome: %s\n|Fone: %s\n|Endereço: %s\n|E-mail: %s\n\n", ptr[i].codigo, ptr[i].nome, ptr[i].telefone, ptr[i].endereco, ptr[i].email);
			controle = 1;
			
			printf("Deseja Editar Esse Contato ? (Informe 1 Caso Sim | Informe 2 Caso Não): ");
			scanf("%d",& conferir);
			
			if(conferir == 1){
				valI = i;
			} else{
				system("cls");
				printf("Voltando Para o Menu\n\n");
		
				system("pause");
				return ptr;
			}
		}
	}
	
	if(controle == 0){
		system("cls");
		
		printf("Código não Cadastrado\n\n");
		printf("Voltando Para o Menu\n\n");

		system("pause");
		return ptr;
	}
	
	system("cls");
	fflush(stdin);
	
	printf("Código Contato: %d\n", ptr[valI].codigo);

	printf("Informe o Novo Nome: ");
	gets(ptr[valI].nome);

	printf("Informe o Novo Fone: ");
	gets(ptr[valI].telefone);

	printf("Informe o Novo Endereço: ");
	gets(ptr[valI].endereco);

	printf("Informe o Novo E-mail: ");
	gets(ptr[valI].email);
	
	return ptr;
}

contato* excluirContatos(contato* ptr,int* cadastros){
	int codigo, valI, controle, conferir, total, j, k;
	
	system("cls");
	printf("Informe o Código do Contato que Deseja Excluir: ");
	fflush(stdin);
	scanf("%d",& codigo);
	
	controle = 0;
	total = *cadastros;
	
	for(int i = 0; i < cadastros; i++){
		if(codigo == ptr[i].codigo){
			printf("\n|Código: %d\n|Nome: %s\n|Fone: %s\n|Endereço: %s\n|E-mail: %s\n\n", ptr[i].codigo, ptr[i].nome, ptr[i].telefone, ptr[i].endereco, ptr[i].email);
			controle = 1;
			
			printf("Deseja Excluir Esse Contato ? (Informe 1 Caso Sim | Informe 2 Caso Não): ");
			scanf("%d",& conferir);
			
			if(conferir == 1){
				for(j = i; j < total - 1; j++){
					k = j + 1;
					ptr[j] = ptr[k];
				}
				*cadastros -= 1;
				
				system("cls");
	
				printf("Contato Excluido com Sucesso!!!\n\n");
	
				system("pause");
				return ptr;
			} else{
				system("cls");
				printf("Voltando Para o Menu\n\n");
		
				system("pause");
				return ptr;
			}
		}
	}
	
	if(controle == 0){
		system("cls");
		
		printf("Código não Cadastrado\n\n");
		printf("Voltando Para o Menu\n\n");

		system("pause");
		return ptr;
	}
}
