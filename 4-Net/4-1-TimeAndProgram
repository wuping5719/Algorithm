using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// C# 程序运行时间和语义理解
namespace TimeAndProgram
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] rg = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 
	                   18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
            for (Int64 i = 1; i < Int64.MaxValue; i++)
            {
                int hit = 0;
                int hit1 = -1;
                int hit2 = -1;
                for (int j = 0; (j < rg.Length) && (hit <= 2); j++)
                {
                    if ((i % rg[j]) != 0)
                    {
                        hit++;
                        if (hit == 1)
                        {
                            hit1 = j;
                        }
                        else if (hit == 2)
                        {
                            hit2 = j;
                        }
                        else
                            break;
                    }
                }

                if ((hit == 2) && (hit1 + 1 == hit2))
                {
                    Console.WriteLine("found {0}", i);
                }
            }
        }
    }
}
