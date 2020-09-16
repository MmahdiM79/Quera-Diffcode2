// by Arad Firoozkuhi




using System;
using System.Linq;

namespace MalmasSoal
{
    class Program
    {
       static bool isSomaghFarmable(int[] array)
        {
            int peakIndex = array.Length-1;
            for(int i=1;i<array.Length;i++)
            {
                if (array[i] < array[i - 1])
                {
                    peakIndex = i - 1;
                    break;
                }
            }
            for(int i=peakIndex;i<array.Length-1;i++)
            {
                if (array[i + 1] >= array[i])
                    return false;
            }
            return true;
        }
        static bool isSomaghFarmable2(int[] array)
        {
            int trough = array.Length - 1;
            for (int i = 1; i < array.Length; i++)
            {
                if (array[i] > array[i - 1])
                {
                    trough = i - 1;
                    break;
                }
            }
            for (int i = trough; i < array.Length - 1; i++)
            {
                if (array[i + 1] <= array[i])
                    return false;
            }
            return true;
        }
        static void Main(string[] args)
        {
            Console.ReadLine();
            string[] inputs = Console.ReadLine().Split();
            int[] convertedArr = inputs.Select(x => int.Parse(x)).ToArray();
            Console.WriteLine(isSomaghFarmable(convertedArr)||isSomaghFarmable2(convertedArr) ? "Yes": "No");
        }
    }
}
