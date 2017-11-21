using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// 线程用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program3
    {
        static void Main(string[] args)
        {
            Thread thread1 = new Thread(new ThreadStart(Task));
            Thread thread2 = new Thread(new ThreadStart(Task));
            thread1.Name = "Thread1";
            thread2.Name = "Thread2";
            thread1.Start();
            // thread1.Join();
            thread2.Start();
            thread2.Priority = ThreadPriority.AboveNormal;
            Console.ReadLine();
        }

        static void Task()
        {
            for(int count=1; count<=100; count++)
            {
                Console.WriteLine("This is {0} : {1}", Thread.CurrentThread.Name, count);
            }
        }
    }
}
