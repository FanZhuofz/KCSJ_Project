#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#define N 15              //最大为15
typedef struct            //定义一个结构
{
  char name[10];	//姓名
  char tel[15];		//电话
  char lb[10];		//类别
  char dz[20];		//地址
}ren;
/*主菜单*/
void menu()				//目录                                 
{
  	system("cls");		//清屏
	printf("\n");
    printf("	手机通讯录管理程序	B14060405 范 卓\n");
    printf("\n");
    printf("*************************************************\n");
    printf("  1==查询           ");
    printf("  2==添加           \n");printf("\n");
    printf("  3==拨号           ");
    printf("  4==修改           \n");printf("\n");
    printf("  5==删除           ");
    printf("  0==退出           \n");
    printf("**************************************************\n");
    printf("\n");
   	printf("请选择操作:");
}
/*查询*/
void chaxun()
{
	ren ry;
	FILE *fp;
	char lb[10];
	system("cls");
	printf("\n输入要查寻人员的类别:\n");
	printf("说明：(A办公类B个人类C商务类)\n");
	scanf("%s",lb);
    if((fp=fopen("ren.dat","rb"))==NULL) {printf("can't open file!\n");exit(0);}
    fread(&ry,sizeof(ren),1,fp);
	if(!feof(fp))
   {
		printf("			人员的信息如下:\n");
		printf("\n%10s %15s %10s %20s \n","姓名","号码","类别","邮箱");
		printf("-----------------------------------------------------------------------\n");
		while(!feof(fp))
		{
			if(strcmp(ry.lb,lb)==0)
			{printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);}
			fread(&ry,sizeof(ren),1,fp);
		}
   }
   else printf("查找失败!!!\n******按0键退出******");
   fclose(fp);
   getch();
}
/*添加*/
void tianjia()
{
     FILE *fp;		//定义文件指针
     ren ry,s;		//定义两个ren结构体的量
     if((fp=fopen("ren.dat","ab+"))==NULL)
		{printf("can't open file!\n");exit(0);}
		printf("\n");
     while(1)
	{  
		printf("请输入姓名：(***输入#则退出添加***)");
		scanf("%s",ry.name);
		if(strcmp(ry.name,"#")==0) break;	//如果输入#则退出添加
        printf("请输入电话号码：");
        scanf("%s",ry.tel);
        printf("请输入类别（A办公类B个人类C商务类）：");
        scanf("%s",ry.lb);
        printf("请输入邮箱地址：");
        scanf("%s",ry.dz);
        fseek(fp,0,0);			//指针定位到文件开始位置
		fread(&s,sizeof(ren),1,fp);
		while(!feof(fp))
		{       
			if(strcmp(s.tel,ry.tel)==0)
			{
				printf("号码已经存在,不能记录.\n******按0键退出******");
				break;		//遇到有相同的号码
			}
            fread(&s,sizeof(ren),1,fp);
		}
       if(feof(fp))		//读到最后也没有相同的号码
       fwrite(&ry,sizeof(ren),1,fp);		//将信息写入文件
	}
	fclose(fp);		//关闭文件
    getchar();		//接受一个输入
}
/*拨号*/
void bohao()
{    
	ren ry;
	FILE *fp;
	char name[10];
	system("cls");
	printf("\n输入要拨人员的姓名: ");scanf("%s",name);
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
	if(feof(fp)) printf("拨号失败!!!\n******按0键退出******");
    fclose(fp);
    getch();
}
/*修改:输入人员的姓名,查找该人员，若找到则修改该人员的信息，并显示修改前后的结果；*/
void xiugai()
{   
	ren ry;
	FILE *fp;
	char name[10];
	system("cls");
	if((fp=fopen("ren.dat","rb+"))==NULL) {printf("can't open file!\n");exit(0);}
	if(!feof(fp))
	{
		printf("   修改前全部人员的信息如下:\n");
		printf("\n%10s %15s %10s %20s \n","姓名","号码","类别","邮箱");
		fread(&ry,sizeof(ren),1,fp);
		while(!feof(fp))
		{
			printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
			fread(&ry,sizeof(ren),1,fp);
		}
	}
	printf("\n输入要修改人员的姓名: ");scanf("%s",name);
    if((fp=fopen("ren.dat","rb+"))==NULL) {printf("can't open file!\n");exit(0);}
	while(!feof(fp))
	{  
		fread(&ry,sizeof(ren),1,fp);
		if(strcmp(ry.name,name)==0)
		{  
			printf("   修改前人员的信息如下:\n");
			printf("\n%10s %15s %10s %20s \n","姓名","号码","类别","邮箱");
			printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
			printf("\n请输入该人的号码:");scanf("%s",ry.tel);
			printf("\n类别:");scanf("%s",ry.lb);
			printf("\n邮箱:");scanf("%s",ry.dz);
			break;
		}
	}
	if(!feof(fp))
	{
      printf("  \n 修改后的人的信息如下:\n******按0键退出******");
	  printf("\n%10s %15s %10s %20s \n","姓名","号码","类别","邮箱");
      printf("%10s %15s %10s %20s \n",ry.name,ry.tel,ry.lb,ry.dz);
      fseek(fp,-sizeof(ren),1);
      fwrite(&ry,sizeof(ren),1,fp);
	}
	else
	printf("\n此人不存在，修改失败!!\n******按0键退出******");
	fclose(fp);
	getch();
}
/*删除:输入人员姓名，若该人员存在，则删除，并显示删除后余下的人员的信息*/
void shanchu()
{   
	ren  ry[N];
    FILE *fp;
    char name[10];
    int i,len,k=-1;
    system("cls");
    printf("\n输入要删除的人员姓名: ");scanf("%s",name);
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
        fclose(fp);printf("删除成功!!!\n******按0键退出******\n");
   }
   else printf("删除失败!!!\n******按0键退出******\n");
   getch();
}
/*主函数*/
void main()
{
	char fz;
	while(1)
	{
		menu();
		fz=getch();
		if(fz=='0') break;		//若输入为0，则退出程序
		switch(fz)
		{
			case '1':chaxun();break;
			case '2':tianjia();break;
			case '3':bohao();break;
			case '4':xiugai();break;
			case '5':shanchu();break;
		}
	}
	printf("\n欢迎使用!!!(***按0键退出***)\n");
}

