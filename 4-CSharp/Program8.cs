using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// 迭代器用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program8
    {
        static void Main(string[] args)
        {
            foreach (long i in Power(2, 12))
            {
                Console.Write("{0} ", i);
            }
            Console.ReadKey();
        }

        public static IEnumerable<long> Power(int number, int exponent)
        {
            int counter = 0;
            long result = 1;
            while (counter++ < exponent)
            {
                result = result * number;
                yield return result;
            }
        }
    }
}
