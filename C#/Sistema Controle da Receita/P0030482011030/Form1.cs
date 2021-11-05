using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.VisualBasic;

namespace P0030482011030
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnVerificar_Click(object sender, EventArgs e)
        {
            string [,] vendasString = new string[10, 4];
            double [,] vendasDouble = new double[10, 4];
            double [] totalMensal = new double[10];
            double totalGeral = 0;
            int mes = 10, semana = 4, i, j;

            //btn

            for(i = 0; i < mes; i++)
            {
                for(j = 0; j < semana; j++)
                {
                    vendasString[i, j] = Interaction.InputBox("Digite o Valor do Mês " + (i + 1).ToString() + " Semana " + (j + 1).ToString(), "Informando Valores");
                    if(double.TryParse(vendasString[i, j], out vendasDouble[i, j])){
                        
                    }
                    else
                    {
                        MessageBox.Show("Informe um Valor Válido");
                        if(j == 0)
                        {
                            i--;
                        }
                        else
                        {
                            j--;
                        }
                    }
                }
                totalMensal[i] = vendasDouble[i, 0] + vendasDouble[i, 1] + vendasDouble[i, 2] + vendasDouble[i, 3];
            }
            for(i = 0; i < mes; i++)
            {
                totalGeral += totalMensal[i];
            }

            //listBox

            for(i = 0; i < mes; i++)
            {
                for(j = 0; j < semana; j++)
                {
                    listSaida.Items.Add($"Total do mês: {i + 1} Semana: {j + 1} {vendasDouble[i, j]:C2}");
                }

                listSaida.Items.Add($">> Total mês {i + 1}: {totalMensal[i]:C2}");
                listSaida.Items.Add("------------------------------------------------------------");
            }

            listSaida.Items.Add($">> Total Geral: {totalGeral:C2}");
        }
    }
}
