using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Runtime.Remoting.Messaging;

namespace CSharpFun
{
    /// <summary>
    /// 线程异步回调用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program4
    {
        static void Main(string[] args)
        {
            Console.WriteLine("===== 异步回调测试 =====");
            AddHandler addHandler = new AddHandler(ClassAdd.Add);

            // 异步操作接口
            IAsyncResult result = addHandler.BeginInvoke(8000, 8000, new AsyncCallback(AsyncCallBackFun), "AsyncState: OK");
            
            Console.WriteLine("我继续干点别的...");
            Console.ReadLine();
        }

        static void AsyncCallBackFun(IAsyncResult result)
        {
            // result 是 "ClassAdd 类的 Add() 方法" 的返回值
            // AsyncResult 是 IAsyncResult 接口的一个实现类，命名空间：System.Runtime.Remoting.Messaging
            // AsyncDelegate 属性可以强制转换为用户自定义的委托实现类
            AddHandler addHandler = (AddHandler)((AsyncResult)result).AsyncDelegate;
            Console.WriteLine(addHandler.EndInvoke(result));
            Console.WriteLine(result.AsyncState);
        }
    }

    public delegate int AddHandler(int a, int b);
    public class ClassAdd
    {
        public static int Add(int a, int b)
        {
            Console.WriteLine("开始计算：" + a + " + " + b);
            Thread.Sleep(3000);  // 模拟方法运行 3 秒
            Console.WriteLine("计算完成！");
            return a + b;
        }
    }
}
