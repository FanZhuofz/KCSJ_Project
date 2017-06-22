#include <stdio.h>
#include <stdlib.h>
#include <String.h>

typedef struct LNode
{
	int num;		//编号
	char add[20];		//部门
	char name[20];		//姓名
	char sex[10];		//性别
	char job[20];		//职称
	int	sala;		//工资
	struct LNode *next;//指针域
}LNode,*LinkList;

//主菜单界面
void menu()
{
	//system("cls");
	//system("color 3f");	//改变颜色
	printf("********欢迎使用业务员业绩管理系统********\n");
	printf("------------------------------------\n");
	printf("	1.   输入数据建立信息表\n");
	printf("	2.   查询满足要求的信息\n");
	printf("	3.   插入新的信息\n");
	printf("	4.   删除不需要的信息\n");
	printf("	5.   查看所有信息\n");
	printf("	6.   修改业务员信息\n");
	printf("	7.   统计和排序功能\n");
	printf("	0.   退出\n");
	printf("------------------------------------\n");
	printf("********欢迎使用业务员业绩管理系统********\n");
	printf("\n");
	printf("请选择要执行的操作：\n");
}

//获取链表长度
int L_Length(LinkList L)
{
    LinkList p;
    p=L;
    int i=0;
	//判断每节链表是否为空
    while(p!=NULL){
         i++;
         p=p->next;
     }
    return i;
}

//显示业务员信息
void Show(LinkList L)
{
	//system("cls");
	LinkList p;
	p=L->next;
	int i;
	printf("                    显示业务员信息  \n");
	printf("-------------------------------------------------------------\n");
	printf("编号 |  部门 |  姓名 |  性别 |  职称 |  工资 \n");
	for(i=0;i<L_Length(L)-1;i++)	//根据链表长度依次输出链表内所有信息
	{	
		printf("%d\t %s\t %s\t %s\t %s\t %d\t \n",p->num,p->add,p->name,p->sex,p->job,p->sala);
		p=p->next;
	}
	printf("-------------------------------------------------------------\n");
	menu();
}

//1. 输入数据建立信息表
void Add(LinkList &L)
{
	system("cls");
	LinkList p;
	int a=1;
	printf("您选择的是：1. 输入数据建立信息表\n");
	L=(LinkList)malloc(sizeof(LNode));	//分配内存
	L->next=NULL;	//先建立一个带头结点的空单链表
	while(a)	//控制返回和继续。如果a=0退出while循环
	{
		p=(LinkList)malloc(sizeof(LNode));//生成新结点
		/*输入信息*/
		printf("请输入业务员编号：");
		scanf("%d",&p->num); 
		while(p->num<0)
		{
			printf("输入格式错误,请重新输入\n");
			printf("请输入业务员编号:");
			scanf("%d",&p->num);
		}
		printf("\n请输入业务员部门：");
		scanf("%s",&p->add);
		printf("\n请输入业务员姓名：");
		scanf("%s",&p->name);
		printf("\n请输入业务员性别：");
		scanf("%s",&p->sex);
		printf("\n请输入业务员职称：");
		scanf("%s",&p->job);
		printf("\n请输入业务员工资：");
		scanf("%d",&p->sala);
		p->next=L->next;
		L->next=p;		//插入到表头，先插入的后移
		printf("<1>==>继续添加,<0>==>返回菜单:");
		scanf("%d",&a);
		while(a!=1 && a!=0)//判断输入是否是1或者0，输入其它数则无效
		{
			printf("输入有误，请重新输入!\n");
			printf("<1>==>继续添加,<0>==>返回菜单:");
			scanf("%d",&a);
		}
	}
	menu();
}

//2. 查询满足要求的信息
void Qur(LinkList L)
{
	int num,a;
	LinkList p;
	p=L->next;
	printf("您选择的是：2. 查询满足要求的信息\n");
	printf("请输入业务员编号进行查找:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p不为空，并循环找到业务员编号与输入编号相同的记录
	{
		p=p->next;		//循环体，依次往下找
	}
	if(p==NULL)	//输入业务员编号不在记录中,输出提示信息
	{
		printf("所输入编号不在记录中!\n");
	}
	else//查找到结点,输出信息
	{
		system("cls");
		printf("                    显示业务员信息  \n");
	printf("-------------------------------------------------------------\n");
		printf("编号 |  部门 |  姓名 |  性别 |  职称 |  工资 \n");
		printf("%d\t %s\t %s\t %s\t %s\t %d\t \n",p->num,p->add,p->name,p->sex,p->job,p->sala);
		printf("输入0返回菜单!");
		scanf("%d",&a);
		if(a==0)
		{
			system("cls");
			menu();
		}
	}
}

//3. 插入新的信息
void Insert(LinkList &L)
{
	system("cls");
	Show(L);//显示所有信息
	LinkList p,s;
	p=L;
	int num;
	printf("您选择的是：3. 插入新的信息\n");
	printf("请输入待插入位置（已经存在的编号之前插入）:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p不为空，并循环找到业务员编号与输入编号相同的记录
	{
		p=p->next;		//循环体，依次往下找
	}
	if(p==NULL)	//输入业务员编号不在记录中,输出提示信息
	{
		printf("所输入编号不在记录中!\n");
	}
	else
	{
		s=(LinkList)malloc(sizeof(LNode));//生成待插入节点

		//输入信息
		printf("请输入待插入的业务员编号:");
		scanf("%d",&s->num);
		while(p->num<0)
		{
			printf("输入格式错误,请重新输入\n");
			printf("请输入待插入的业务员编号:");
			scanf("%d",&s->num);
		}
		printf("\n请输入业务员部门：");
		scanf("%s",&s->add);
		printf("\n请输入业务员姓名：");
		scanf("%s",&s->name);
		printf("\n请输入业务员性别：");
		scanf("%s",&s->sex);
		printf("\n请输入业务员职称：");
		scanf("%s",&s->job);
		printf("\n请输入业务员工资：");
		scanf("%d",&s->sala);
		s->next=p->next;
		p->next=s;	//插入到链表中
		printf("插入成功!\n");
		Show(L);//显示信息
	}
}

//4.删除不需要的信息（根据编号）
void Del(LinkList &L)
{
	int num;
	LinkList p,q;
	q=L;
	p=L->next;
	printf("您选择的是：4. 删除不需要的信息\n");
	printf("请输入删除信息的业务员编号:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p不为空，并循环找到业务员编号与输入编号相同的记录
	{
		//q=q->next;
		p=p->next;	//循环体，依次往下找
	}
	if(p==NULL)//输入业务员编号不在记录中,输出提示信息
	{
		printf("删除业务员编号不在记录中!\n");
	}
	else
	{
		q->next=p->next;
		free(p);//删除并释放结点
	}
	printf("删除成功!\n");
	Show(L);//显示信息
}

//5.查看所有信息(调用显示)
void Search(LinkList L)
{
	system("cls");
	printf("您选择的是：5. 查看所有信息\n");
	Show(L);
}

//6.修改信息(调用插入、删除)
void Revise(LinkList L)
{
	int num;
	LinkList p,q,s;
	q=L;
	p=L->next;
	printf("请输入待修改信息的业务员编号:");
	scanf("%d",&num);
	while(p&&p->num!=num)//循环找到业务员编号与输入相同的记录
	{
		//q=q->next;
		p=p->next;
	}
	if(p==NULL)//输入业务员编号不在记录中,输出提示信息
	{
		printf("该业务员编号不在记录中!\n");
	}
	else
	{
		q->next=p->next;
		free(p);//删除并释放结点
	}
	s=(LinkList)malloc(sizeof(LNode));//生成待插入节点
	printf("请输入新的业务员编号：");
	scanf("%d",&p->num);
	while(p->num<0)
		{
			printf("输入格式错误,请重新输入\n");
			printf("请输入新的业务员编号:");
			scanf("%d",&p->num);
		}
	printf("\n请输入业务员部门：");
	scanf("%s",&p->add);
	printf("\n请输入业务员姓名：");
	scanf("%s",&p->name);
	printf("\n请输入业务员性别：");
	scanf("%s",&p->sex);
	printf("\n请输入业务员职称：");
	scanf("%s",&p->job);
	printf("\n请输入业务员工资：");
	scanf("%d",&p->sala);

	s->next=q->next;
	q->next=s;//插入到链表中
	printf("修改成功\n");
	Show(L);//显示信息
	menu();
}

//7.统计排序（冒泡排序）
void Sort(LinkList L){
	LinkList p, pn, pr;
	p = L;
	for (int y=L_Length(L)-1;y>=0; y--)	//调用表长依次比较
	{
		pr = L;
		p = pr->next;
		pn = p->next;
		while (pn != NULL)
		{
			if (p->num > pn->num)	//三个结点两两比较互换位置从小到大排列
			{	
				p->next = pn->next;
				pn->next = p;
				pr->next = pn;
			}
			pr = pr->next;
			p = pr->next;
			pn = p->next;
		}
	}
	Show(L);
}

//主函数
int main()
{
	LinkList L;
	printf("   B14060405		范  卓\n");
	printf("\n\n\n");
	menu();		//调用主菜单
	int ch;
	while(scanf("%d",&ch))	//实现循环输入功能！
	{
		switch(ch) 
		{		
			  case 0:menu();exit(0);	//退出系统
		      case 1:Add(L);break;       //创建输入    
		      case 2:Qur(L); break;      //条件查询
		      case 3:Insert(L);break;    //插入信息      
		      case 4:Del(L); break;      //删除信息    
		      case 5:Search(L);break;	//查看所有信息
			  case 6:Revise(L);break;	//修改信息
			  case 7:Sort(L);break;		//按编号排序
		} 
	}
}

