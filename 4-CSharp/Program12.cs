using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Security.Cryptography;
using System.IO;

namespace CSharpFun
{
    /// <summary>
    /// 加解密算法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-23
    class Program12
    {
        static void Main(string[] args)
        {
            Console.Write("请输入要加密的字符串：");  // 提示输入字符串      
            Console.WriteLine();      // 换行输入   
            string str = Console.ReadLine();     // 记录输入的字符串 
            string encryptKey = "love";
            string strNew = Encrypt(str, encryptKey);    // 加密字符串      
            Console.WriteLine("加密后的字符串：" + strNew);  // 输出加密后的字符串      
            Console.WriteLine("解密后的字符串：" + Decrypt(strNew, encryptKey));  // 解密字符串并输出     
            Console.ReadLine();
        } 

        static string Encrypt(string str, string encryptKey)
        {
            DESCryptoServiceProvider descsp = new DESCryptoServiceProvider();   // 实例化加/解密类对象   

            byte[] key = Encoding.Unicode.GetBytes(encryptKey); // 定义字节数组，用来存储密钥    

            byte[] data = Encoding.Unicode.GetBytes(str);  // 定义字节数组，用来存储要加密的字符串  

            byte[] iv = Encoding.Unicode.GetBytes("Myra");  // 初始化向量

            MemoryStream mStream = new MemoryStream(); // 实例化内存流对象      

            // 使用内存流实例化加密流对象   
            CryptoStream CStream = new CryptoStream(mStream, descsp.CreateEncryptor(key, iv), CryptoStreamMode.Write);
            
            CStream.Write(data, 0, data.Length);  // 向加密流中写入数据      

            CStream.FlushFinalBlock();      // 释放加密流      

            return Convert.ToBase64String(mStream.ToArray()); // 返回加密后的字符串  
        }

        static string Decrypt(string str, string encryptKey)
        {

            DESCryptoServiceProvider descsp = new DESCryptoServiceProvider();   // 实例化加/解密类对象    

            byte[] key = Encoding.Unicode.GetBytes(encryptKey); // 定义字节数组，用来存储密钥    

            byte[] data = Convert.FromBase64String(str); // 定义字节数组，用来存储要解密的字符串  

            byte[] iv = Encoding.Unicode.GetBytes("Myra");  // 初始化向量

            MemoryStream mStream = new MemoryStream(); // 实例化内存流对象      

            // 使用内存流实例化解密流对象       
            CryptoStream CStream = new CryptoStream(mStream, descsp.CreateDecryptor(key, iv), CryptoStreamMode.Write);

            CStream.Write(data, 0, data.Length);      // 向解密流中写入数据     

            CStream.FlushFinalBlock();    // 释放解密流      

            return Encoding.Unicode.GetString(mStream.ToArray());    // 返回解密后的字符串  
        }
    }
}
