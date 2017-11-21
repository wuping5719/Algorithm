using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// Lambda 表达式用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program5
    {
        static void Main(string[] args)
        {
            SayLove sayLove = p => p * 1000;
            Console.WriteLine("I love Myra " + sayLove(10) + " years."); // 表达式的应用
            Console.ReadKey();
        }

        // 委托，表达爱
        delegate int SayLove(int a);
    }
}
