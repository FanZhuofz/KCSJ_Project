#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#define N 15              //���Ϊ15
typedef struct            //����һ���ṹ
{
  char name[10];	//����
  char tel[15];		//�绰
  char lb[10];		//���
  char dz[20];		//��ַ
}ren;
/*���˵�*/
void menu()				//Ŀ¼                                 
{
  	system("cls");		//����
	printf("\n");
    printf("	�ֻ�ͨѶ¼�������	B14060405 �� ׿\n");
    printf("\n");
    printf("*************************************************\n");
    printf("  1==��ѯ           ");
    printf("  2==���           \n");printf("\n");
    printf("  3==����           ");
    printf("  4==�޸�           \n");printf("\n");
    printf("  5==ɾ��           ");
    printf("  0==�˳�           \n");
    printf("**************************************************\n");
    printf("\n");
   	printf("��ѡ�����:");
}
/*��ѯ*/
void chaxun()
{
	ren ry;
	FILE *fp;
	char lb[10];
	system("cls");
	printf("\n����Ҫ��Ѱ��Ա�����:\n");
	printf("˵����(A�칫��B������C������)\n");
	scanf("%s",lb);
    if((fp=fopen("ren.dat","rb"))==NULL) {printf("can't open file!\n");exit(0);}
    fread(&ry,sizeof(ren),1,fp);
	if(!feof(fp))
   {
		printf("			��Ա����Ϣ����:\n");
		printf("\n%10s %15s %10s %20s \n","����","����","���","����");
		printf("-----------------------------------------------------------------------\n");
		while(!feof(fp))
		{
			if(strcmp(ry.lb,lb)==0)
			{printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);}
			fread(&ry,sizeof(ren),1,fp);
		}
   }
   else printf("����ʧ��!!!\n******��0���˳�******");
   fclose(fp);
   getch();
}
/*���*/
void tianjia()
{
     FILE *fp;		//�����ļ�ָ��
     ren ry,s;		//��������ren�ṹ�����
     if((fp=fopen("ren.dat","ab+"))==NULL)
		{printf("can't open file!\n");exit(0);}
		printf("\n");
     while(1)
	{  
		printf("������������(***����#���˳����***)");
		scanf("%s",ry.name);
		if(strcmp(ry.name,"#")==0) break;	//�������#���˳����
        printf("������绰���룺");
        scanf("%s",ry.tel);
        printf("���������A�칫��B������C�����ࣩ��");
        scanf("%s",ry.lb);
        printf("�����������ַ��");
        scanf("%s",ry.dz);
        fseek(fp,0,0);			//ָ�붨λ���ļ���ʼλ��
		fread(&s,sizeof(ren),1,fp);
		while(!feof(fp))
		{       
			if(strcmp(s.tel,ry.tel)==0)
			{
				printf("�����Ѿ�����,���ܼ�¼.\n******��0���˳�******");
				break;		//��������ͬ�ĺ���
			}
            fread(&s,sizeof(ren),1,fp);
		}
       if(feof(fp))		//�������Ҳû����ͬ�ĺ���
       fwrite(&ry,sizeof(ren),1,fp);		//����Ϣд���ļ�
	}
	fclose(fp);		//�ر��ļ�
    getchar();		//����һ������
}
/*����*/
void bohao()
{    
	ren ry;
	FILE *fp;
	char name[10];
	system("cls");
	printf("\n����Ҫ����Ա������: ");scanf("%s",name);
    if((fp=fopen("ren.dat","rb"))==NULL) {printf("can't open file!\n");exit(0);}
    while(!feof(fp))
	{     
		fread(&ry,sizeof(ren),1,fp);
        if(strcmp(ry.name,name)==0)
		{  
			printf("\n\a\a\a\a\a\a %15s\a\a\a\a\a\n",ry.tel);
            break;
		}
	}
	if(feof(fp)) printf("����ʧ��!!!\n******��0���˳�******");
    fclose(fp);
    getch();
}
/*�޸�:������Ա������,���Ҹ���Ա�����ҵ����޸ĸ���Ա����Ϣ������ʾ�޸�ǰ��Ľ����*/
void xiugai()
{   
	ren ry;
	FILE *fp;
	char name[10];
	system("cls");
	if((fp=fopen("ren.dat","rb+"))==NULL) {printf("can't open file!\n");exit(0);}
	if(!feof(fp))
	{
		printf("   �޸�ǰȫ����Ա����Ϣ����:\n");
		printf("\n%10s %15s %10s %20s \n","����","����","���","����");
		fread(&ry,sizeof(ren),1,fp);
		while(!feof(fp))
		{
			printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
			fread(&ry,sizeof(ren),1,fp);
		}
	}
	printf("\n����Ҫ�޸���Ա������: ");scanf("%s",name);
    if((fp=fopen("ren.dat","rb+"))==NULL) {printf("can't open file!\n");exit(0);}
	while(!feof(fp))
	{  
		fread(&ry,sizeof(ren),1,fp);
		if(strcmp(ry.name,name)==0)
		{  
			printf("   �޸�ǰ��Ա����Ϣ����:\n");
			printf("\n%10s %15s %10s %20s \n","����","����","���","����");
			printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
			printf("\n��������˵ĺ���:");scanf("%s",ry.tel);
			printf("\n���:");scanf("%s",ry.lb);
			printf("\n����:");scanf("%s",ry.dz);
			break;
		}
	}
	if(!feof(fp))
	{
      printf("  \n �޸ĺ���˵���Ϣ����:\n******��0���˳�******");
	  printf("\n%10s %15s %10s %20s \n","����","����","���","����");
      printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
      fseek(fp,-sizeof(ren),1);
      fwrite(&ry,sizeof(ren),1,fp);
	}
	else
	printf("\n���˲����ڣ��޸�ʧ��!!\n******��0���˳�******");
	fclose(fp);
	getch();
}
/*ɾ��:������Ա������������Ա���ڣ���ɾ��������ʾɾ�������µ���Ա����Ϣ*/
void shanchu()
{   
	ren  ry[N];
    FILE *fp;
    char name[10];
    int i,len,k=-1;
    system("cls");
    printf("\n����Ҫɾ������Ա����: ");scanf("%s",name);
    i=0;
    if((fp=fopen("ren.dat","rb+"))==NULL) {printf("can't open file!\n");exit(0);}
    while(!feof(fp))
	{     
		fread(&ry[i],sizeof(ren),1,fp);
		if(feof(fp)) break;
		if(strcmp(ry[i].name,name)==0) k=i;
		i++;
	}
    fclose(fp);
	len=i;
	if(k>=0)
   {    
		if((fp=fopen("ren.dat","wb+"))==NULL) {printf("can't open file!\n");exit(0);}
        for(i=0;i<len;i++)
		{   
			if(i==k) continue;
            fwrite(&ry[i],sizeof(ren),1,fp);
		}
        fclose(fp);printf("ɾ���ɹ�!!!\n******��0���˳�******\n");
   }
   else printf("ɾ��ʧ��!!!\n******��0���˳�******\n");
   getch();
}
/*������*/
void main()
{
	char fz;
	while(1)
	{
		menu();
		fz=getch();
		if(fz=='0') break;		//������Ϊ0�����˳�����
		switch(fz)
		{
			case '1':chaxun();break;
			case '2':tianjia();break;
			case '3':bohao();break;
			case '4':xiugai();break;
			case '5':shanchu();break;
		}
	}
	printf("\n��ӭʹ��!!!(***��0���˳�***)\n");
}

