//大数相加: a = b + c;
void BigAddBig(char *a,char *b,char *c)
{
    //a表示结果，b,c位加数
    int a_int[1005]={0},b_int[1005]={0},c_int[1005]={0};
    int len1,len2,len,i;
    len1=strlen(b);
    len2=strlen(c);
    for(i=0;i<len1;i++)
        b_int[i]=b[len1-1-i]-'0';
    for(i=0;i<len2;i++)
        c_int[i]=c[len2-1-i]-'0';
    len=len1>len2?len1:len2;
    for(i=0;i<len;i++)
    {
        a_int[i]+=b_int[i]+c_int[i];
        if(a_int[i]>9)
        {
            a_int[i+1]=a_int[i]/10;
            a_int[i]=a_int[i]%10;
        }
    }
    if(a_int[i]!=0)
        len++;
    while(!a_int[len-1])
        len--;
    for(i=0;i<len;i++)
        a[i]=a_int[len-1-i]+'0';
    a[i]='\0';
}

//大数乘小数
void BigNumMultiSmall(char *a,char *b,int mul)
{
    //a表示结果，b表示被乘数，mul表示乘数
    int i,j,len;
    int a_int[2000]={0},b_int[1000]={0};
    len=strlen(b);
    for(i=0;i<len;i++)
         b_int[i]=b[len-1-i]-'0';
    for(i=0;i<len;i++)
    {
        a_int[i]=a_int[i]+b_int[i]*mul;
        if(a_int[i]>9)
        {
            a_int[i+1]=a_int[i]/10;
            a_int[i]=a_int[i]%10;
        }
    }
    while(a_int[i])
    {
        a_int[i+1]=a_int[i]/10;
        a_int[i]=a_int[i]%10;
        i++;
    }
    while(a_int[i-1]==0)
        i--;
    for(j=0;j<i;j++)
        a[j]=a_int[i-j-1]+'0'; 
    a[j]='\0';
}

//大数乘大数
void BigMultiBig(char *a,char *b,char *c)
{
    int i,j,len1,len2,len;
    int a_int[2010]={0},b_int[1000]={0},c_int[1000]={0};
     
    len1=strlen(b);
    for(i=len1-1;i>=0;i--)
        b_int[len1-i-1]=b[i]-'0';
    len2=strlen(c);
    for(i=len2-1;i>=0;i--)
        c_int[len2-i-1]=c[i]-'0';
     
    len=len1+len2;
     
    for(i=0;i<len1;i++)
        for(j=0;j<len2;j++)
            a_int[i+j]+=b_int[i]*c_int[j];
        for(i=0;i<len;i++)
            if(a_int[i]>9)
            {
                a_int[i+1]+=a_int[i]/10;
                a_int[i]=a_int[i]%10;
            }
            while(a_int[len-1]==0)
                len--;
 
        for(i=0;i<len;i++)
            a[i]=a_int[len-i-1]+'0';
        a[i]='\0';
        if(strlen(a)==0)
            strcpy(a,"0");
}
 
//大数除小数
int BigNumDividSmall(char *a,char *b,int div)
{
    //z是余数，a是结果，b是被除数，div是除数
    int i,a_int[1000]={0},b_int[1000]={0};
    int len=strlen(b);
    for(i=0;i<len;i++)
        b_int[i]=b[i]-'0';
 
    int z=0;
    for(i=0;i<len;i++)
    { 
        z=b_int[i]+z*10;
        a_int[i]=z/div;
        z=z%div;
    }
 
    int t=0;
    while(t<1000&&!a_int[t])
        t++;
    if(t==1000)
    {
        a[0]='0';
        a[1]='\0';
    }
    else
    {
        for(i=0;i<len-t;i++)
            a[i]=a_int[i+t]+'0';
        a[i]='\0';
    }
    return z;
}
