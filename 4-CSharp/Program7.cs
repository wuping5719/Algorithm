using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// 泛型委托用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program7
    {
        static void Main(string[] args)
        {
            // 创建委托实例
            NumberChanger<int> nc1 = new NumberChanger<int>(addNum);
            NumberChanger<int> nc2 = new NumberChanger<int>(multNum);
            // 使用委托对象调用方法
            nc1(50);
            Console.WriteLine("Current value of num : {0}", getNum());
            nc2(8);
            Console.WriteLine("Current value of num : {0}", getNum());
            Console.ReadKey();
        }

        delegate T NumberChanger<T>(T n);

        static int num = 10;

        public static int addNum(int a)
        {
            num += a;
            return num;
        }

        public static int multNum(int m)
        {
            num *= m;
            return num;
        }

        public static int getNum()
        {
            return num;
        }
    }
}
