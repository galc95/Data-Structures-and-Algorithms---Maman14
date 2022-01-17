import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HeapManager
{
    listStack stack;

    public HeapManager()
    {
        stack  = new listStack();
    }

   
    public static String readCMD()
    {
        Scanner cli = new Scanner(System.in);
        System.out.println("in readCMD");
        String command = cli.nextLine();
        cli.close();
        return command;
    }

    public void cmdRunner(String input, int mode)
    {
        String[] cmd = input.trim().split(" ");
        //System.out.println(cmd[0]);
        //System.out.println(cmd[1]);
        switch(cmd[0])
        {
            case "MakeHeap":
            {
                switch(mode)
                {
                    case 1:
                    {
                       stack.Push(new Ordered()); 
                       System.out.println("New Ordered Heap Created");
                       break;
                    }   
                    case 2:
                    {
                        stack.Push(new Unordered());
                        System.out.println("New Unordered Heap Created");
                        break;
                    }
                    case 3:
                    {
                        stack.Push(new UnorderedUnique());
                        System.out.println("New Unique Unordered Heap Created");
                        break;
                    }
                    default:
                        {
                            System.out.println("Invalid mode");
                            break;
                        }
                }
                break;

            }
            case "Insert":
                {
                    //System.out.println(cmd[1]);
                    int num = Integer.parseInt(cmd[1]);
                    stack.Peek().Insert(num);
                    stack.Peek().printHeap();
                    
                    break;
                }
            case "ExtractMin":
                {
                    stack.Peek().ExtractMin();
                    break;
                }

            case "Minimum":
                {
                    stack.Peek().Minimum();
                    break;
                }
            case "Union":
                {
                    MergableHeap heap1 = stack.Pop();
                    MergableHeap heap2 = stack.Pop();
                    heap1.Union(heap2);
                    stack.Push(heap1);
                    System.out.println("Union Success, the new heap is now:");
                    stack.Peek().printHeap();
                    break;
                }

            case "Print":
                {
                    stack.Peek().printHeap();
                    break;
                }
            default:
            {
                System.out.println("Command not found");
                break;
            }
        }
        


    }

    public static void main(String[] args) throws FileNotFoundException
    {
        int mode = 0;
        int interaction = 0;
        
        HeapManager mgr = new HeapManager();

        Scanner scan = new Scanner(System.in);
    
        while ( mode < 1 || mode > 3)
        {
            System.out.println("Please enter the correct mode - (1) Ordered, (2) Unordered (3), UnorderedUnique");
            mode = scan.nextInt();
           
        }
        while (interaction < 1 || interaction > 2)
        {
            System.out.println("Please select CLI (1) or file Import (2)");
            interaction = scan.nextInt();
        }
        


        
        if (interaction == 1)
        {
            System.out.println("Entered CLI mode - enter 'exit' to end the program");
            while (true)
            {
                String command = scan.nextLine();
                if (command == "exit")
                {
                    break;
                }
                mgr.cmdRunner(command, mode);
                
            }   
            scan.close();
        }
        
        else if (interaction == 2)
        {
            
            System.out.println("Please enter the filepath: C:/X/X/X");
            Scanner scanpath = new Scanner(System.in);
            String path = scanpath.next();
            scanpath.close();   
            String cmd;
            //path = scan.nextLine();
            File text = new File(path);
            Scanner filescan = new Scanner(text);
            while (filescan.hasNextLine())
            {
                cmd = filescan.nextLine();
                mgr.cmdRunner(cmd, mode);

                
            }
            filescan.close();
            scan.close();
        }
        {
        





            
    }

        
        
        
        
    
    
    
    
    }
   




}  
