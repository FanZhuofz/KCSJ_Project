#include <stdio.h>
#include <stdlib.h>
#include <String.h>

typedef struct LNode
{
	int num;		//���
	char add[20];		//����
	char name[20];		//����
	char sex[10];		//�Ա�
	char job[20];		//ְ��
	int	sala;		//����
	struct LNode *next;//ָ����
}LNode,*LinkList;

//���˵�����
void menu()
{
	//system("cls");
	//system("color 3f");	//�ı���ɫ
	printf("********��ӭʹ��ҵ��Աҵ������ϵͳ********\n");
	printf("------------------------------------\n");
	printf("	1.   �������ݽ�����Ϣ��\n");
	printf("	2.   ��ѯ����Ҫ�����Ϣ\n");
	printf("	3.   �����µ���Ϣ\n");
	printf("	4.   ɾ������Ҫ����Ϣ\n");
	printf("	5.   �鿴������Ϣ\n");
	printf("	6.   �޸�ҵ��Ա��Ϣ\n");
	printf("	7.   ͳ�ƺ�������\n");
	printf("	0.   �˳�\n");
	printf("------------------------------------\n");
	printf("********��ӭʹ��ҵ��Աҵ������ϵͳ********\n");
	printf("\n");
	printf("��ѡ��Ҫִ�еĲ�����\n");
}

//��ȡ������
int L_Length(LinkList L)
{
    LinkList p;
    p=L;
    int i=0;
	//�ж�ÿ�������Ƿ�Ϊ��
    while(p!=NULL){
         i++;
         p=p->next;
     }
    return i;
}

//��ʾҵ��Ա��Ϣ
void Show(LinkList L)
{
	//system("cls");
	LinkList p;
	p=L->next;
	int i;
	printf("                    ��ʾҵ��Ա��Ϣ  \n");
	printf("-------------------------------------------------------------\n");
	printf("��� |  ���� |  ���� |  �Ա� |  ְ�� |  ���� \n");
	for(i=0;i<L_Length(L)-1;i++)	//�����������������������������Ϣ
	{	
		printf("%d\t %s\t %s\t %s\t %s\t %d\t \n",p->num,p->add,p->name,p->sex,p->job,p->sala);
		p=p->next;
	}
	printf("-------------------------------------------------------------\n");
	menu();
}

//1. �������ݽ�����Ϣ��
void Add(LinkList &L)
{
	system("cls");
	LinkList p;
	int a=1;
	printf("��ѡ����ǣ�1. �������ݽ�����Ϣ��\n");
	L=(LinkList)malloc(sizeof(LNode));	//�����ڴ�
	L->next=NULL;	//�Ƚ���һ����ͷ���Ŀյ�����
	while(a)	//���Ʒ��غͼ��������a=0�˳�whileѭ��
	{
		p=(LinkList)malloc(sizeof(LNode));//�����½��
		/*������Ϣ*/
		printf("������ҵ��Ա��ţ�");
		scanf("%d",&p->num); 
		while(p->num<0)
		{
			printf("�����ʽ����,����������\n");
			printf("������ҵ��Ա���:");
			scanf("%d",&p->num);
		}
		printf("\n������ҵ��Ա���ţ�");
		scanf("%s",&p->add);
		printf("\n������ҵ��Ա������");
		scanf("%s",&p->name);
		printf("\n������ҵ��Ա�Ա�");
		scanf("%s",&p->sex);
		printf("\n������ҵ��Աְ�ƣ�");
		scanf("%s",&p->job);
		printf("\n������ҵ��Ա���ʣ�");
		scanf("%d",&p->sala);
		p->next=L->next;
		L->next=p;		//���뵽��ͷ���Ȳ���ĺ���
		printf("<1>==>�������,<0>==>���ز˵�:");
		scanf("%d",&a);
		while(a!=1 && a!=0)//�ж������Ƿ���1����0����������������Ч
		{
			printf("������������������!\n");
			printf("<1>==>�������,<0>==>���ز˵�:");
			scanf("%d",&a);
		}
	}
	menu();
}

//2. ��ѯ����Ҫ�����Ϣ
void Qur(LinkList L)
{
	int num,a;
	LinkList p;
	p=L->next;
	printf("��ѡ����ǣ�2. ��ѯ����Ҫ�����Ϣ\n");
	printf("������ҵ��Ա��Ž��в���:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p��Ϊ�գ���ѭ���ҵ�ҵ��Ա�������������ͬ�ļ�¼
	{
		p=p->next;		//ѭ���壬����������
	}
	if(p==NULL)	//����ҵ��Ա��Ų��ڼ�¼��,�����ʾ��Ϣ
	{
		printf("�������Ų��ڼ�¼��!\n");
	}
	else//���ҵ����,�����Ϣ
	{
		system("cls");
		printf("                    ��ʾҵ��Ա��Ϣ  \n");
	printf("-------------------------------------------------------------\n");
		printf("��� |  ���� |  ���� |  �Ա� |  ְ�� |  ���� \n");
		printf("%d\t %s\t %s\t %s\t %s\t %d\t \n",p->num,p->add,p->name,p->sex,p->job,p->sala);
		printf("����0���ز˵�!");
		scanf("%d",&a);
		if(a==0)
		{
			system("cls");
			menu();
		}
	}
}

//3. �����µ���Ϣ
void Insert(LinkList &L)
{
	system("cls");
	Show(L);//��ʾ������Ϣ
	LinkList p,s;
	p=L;
	int num;
	printf("��ѡ����ǣ�3. �����µ���Ϣ\n");
	printf("�����������λ�ã��Ѿ����ڵı��֮ǰ���룩:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p��Ϊ�գ���ѭ���ҵ�ҵ��Ա�������������ͬ�ļ�¼
	{
		p=p->next;		//ѭ���壬����������
	}
	if(p==NULL)	//����ҵ��Ա��Ų��ڼ�¼��,�����ʾ��Ϣ
	{
		printf("�������Ų��ڼ�¼��!\n");
	}
	else
	{
		s=(LinkList)malloc(sizeof(LNode));//���ɴ�����ڵ�

		//������Ϣ
		printf("������������ҵ��Ա���:");
		scanf("%d",&s->num);
		while(p->num<0)
		{
			printf("�����ʽ����,����������\n");
			printf("������������ҵ��Ա���:");
			scanf("%d",&s->num);
		}
		printf("\n������ҵ��Ա���ţ�");
		scanf("%s",&s->add);
		printf("\n������ҵ��Ա������");
		scanf("%s",&s->name);
		printf("\n������ҵ��Ա�Ա�");
		scanf("%s",&s->sex);
		printf("\n������ҵ��Աְ�ƣ�");
		scanf("%s",&s->job);
		printf("\n������ҵ��Ա���ʣ�");
		scanf("%d",&s->sala);
		s->next=p->next;
		p->next=s;	//���뵽������
		printf("����ɹ�!\n");
		Show(L);//��ʾ��Ϣ
	}
}

//4.ɾ������Ҫ����Ϣ�����ݱ�ţ�
void Del(LinkList &L)
{
	int num;
	LinkList p,q;
	q=L;
	p=L->next;
	printf("��ѡ����ǣ�4. ɾ������Ҫ����Ϣ\n");
	printf("������ɾ����Ϣ��ҵ��Ա���:");
	scanf("%d",&num);
	while(p&&p->num!=num)//p��Ϊ�գ���ѭ���ҵ�ҵ��Ա�������������ͬ�ļ�¼
	{
		//q=q->next;
		p=p->next;	//ѭ���壬����������
	}
	if(p==NULL)//����ҵ��Ա��Ų��ڼ�¼��,�����ʾ��Ϣ
	{
		printf("ɾ��ҵ��Ա��Ų��ڼ�¼��!\n");
	}
	else
	{
		q->next=p->next;
		free(p);//ɾ�����ͷŽ��
	}
	printf("ɾ���ɹ�!\n");
	Show(L);//��ʾ��Ϣ
}

//5.�鿴������Ϣ(������ʾ)
void Search(LinkList L)
{
	system("cls");
	printf("��ѡ����ǣ�5. �鿴������Ϣ\n");
	Show(L);
}

//6.�޸���Ϣ(���ò��롢ɾ��)
void Revise(LinkList L)
{
	int num;
	LinkList p,q,s;
	q=L;
	p=L->next;
	printf("��������޸���Ϣ��ҵ��Ա���:");
	scanf("%d",&num);
	while(p&&p->num!=num)//ѭ���ҵ�ҵ��Ա�����������ͬ�ļ�¼
	{
		//q=q->next;
		p=p->next;
	}
	if(p==NULL)//����ҵ��Ա��Ų��ڼ�¼��,�����ʾ��Ϣ
	{
		printf("��ҵ��Ա��Ų��ڼ�¼��!\n");
	}
	else
	{
		q->next=p->next;
		free(p);//ɾ�����ͷŽ��
	}
	s=(LinkList)malloc(sizeof(LNode));//���ɴ�����ڵ�
	printf("�������µ�ҵ��Ա��ţ�");
	scanf("%d",&p->num);
	while(p->num<0)
		{
			printf("�����ʽ����,����������\n");
			printf("�������µ�ҵ��Ա���:");
			scanf("%d",&p->num);
		}
	printf("\n������ҵ��Ա���ţ�");
	scanf("%s",&p->add);
	printf("\n������ҵ��Ա������");
	scanf("%s",&p->name);
	printf("\n������ҵ��Ա�Ա�");
	scanf("%s",&p->sex);
	printf("\n������ҵ��Աְ�ƣ�");
	scanf("%s",&p->job);
	printf("\n������ҵ��Ա���ʣ�");
	scanf("%d",&p->sala);

	s->next=q->next;
	q->next=s;//���뵽������
	printf("�޸ĳɹ�\n");
	Show(L);//��ʾ��Ϣ
	menu();
}

//7.ͳ������ð������
void Sort(LinkList L){
	LinkList p, pn, pr;
	p = L;
	for (int y=L_Length(L)-1;y>=0; y--)	//���ñ����αȽ�
	{
		pr = L;
		p = pr->next;
		pn = p->next;
		while (pn != NULL)
		{
			if (p->num > pn->num)	//������������Ƚϻ���λ�ô�С��������
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

//������
int main()
{
	LinkList L;
	printf("   B14060405		��  ׿\n");
	printf("\n\n\n");
	menu();		//�������˵�
	int ch;
	while(scanf("%d",&ch))	//ʵ��ѭ�����빦�ܣ�
	{
		switch(ch) 
		{		
			  case 0:menu();exit(0);	//�˳�ϵͳ
		      case 1:Add(L);break;       //��������    
		      case 2:Qur(L); break;      //������ѯ
		      case 3:Insert(L);break;    //������Ϣ      
		      case 4:Del(L); break;      //ɾ����Ϣ    
		      case 5:Search(L);break;	//�鿴������Ϣ
			  case 6:Revise(L);break;	//�޸���Ϣ
			  case 7:Sort(L);break;		//���������
		} 
	}
}

