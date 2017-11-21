using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// LINQ 查询用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program2
    {
        static void Main(string[] args)
        {
            // 获取数据源
            int[] numbers = new int[8] { 0, 1, 2, 3, 4, 5, 6, 7 };

            // 创建查询
            var numQuery = from num in numbers
                           where (num % 2) == 0
                           select num;

            // 执行查询
            foreach (int n in numQuery) 
            {
                Console.Write("{0, 2}", n);
            }
            Console.ReadLine();
        }
    }
}
