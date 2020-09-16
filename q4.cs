// by Arad Firoozkuhi


using System;

namespace MalmasSoal
{
    class Program
    {
        static bool isValidIP(string[] ipPieces)
        {
            int tmp;
            for (int i = 0; i < ipPieces.Length; i++)
            {

                if ((ipPieces[i][0] == '0' && ipPieces[i].Length > 1) )
                    return false;

                if (!int.TryParse(ipPieces[i], out tmp) || tmp > 255)
                    return false;
            }
            return true;
        }
        
        static string[] quadSplit(string inputString,int index1,int index2,int index3)
        {
            string[] res = new string[4];
            res[0] = inputString.Substring(0, index1);
            res[1] = inputString.Substring(index1, index2-index1);
            res[2] = inputString.Substring(index2, index3-index2);
            res[3] = inputString.Substring(index3, inputString.Length-index3);
            return res;
        }
        static void printQuadStringAsIP(string[] str)
        {
            for (int i = 0; i < str.Length; i++)
            {
                Console.Write(str[i]);
                if (i != str.Length - 1)
                    Console.Write('.');
            }
            Console.WriteLine();
        }
        static void generateIPs(string mainInput)
        {
            
            for(int i=3;i<mainInput.Length;i++)
            {
                for(int j=2;j<i;j++)
                {
                    for(int k=1;k<j;k++)
                    {
                        string[] quadSplitStr = quadSplit(mainInput, k, j, i);
                        if (isValidIP(quadSplitStr))
                            printQuadStringAsIP(quadSplitStr);
                    }
                }
            }
        }
        static void Main(string[] args)
        {
            
                generateIPs(Console.ReadLine());
        }
    }
}
