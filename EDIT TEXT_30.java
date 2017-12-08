package editingtext;

import java.util.*;

    class data{
        char huruf;
        data next;
        data prev;
    }
    
public class Editingtext{
 data baru, head=null, tail=null, temp, hapus, cetak, move;

int pil,jmlh,x=0,i,in=0,maks,status=0;
public void tambah ()
{
        baru = new data();
        baru.next = null;
        baru.prev = null;
        if(head==null)
        {
            head = baru;
            move = baru;
        }
        else 
        {
            if(status==0)
            {
                if(move.next!= null)
                {
                    move.next.prev = baru;
                }
                baru.next = move.next;
                move.next = baru;
                baru.prev = move;
                move = move.next;
            }
            else 
            {
                if(move.prev != null)
                {
                    move.prev.next = baru;
                }
                else 
                {
                    head = baru;
                }
                baru.next = move;
                baru.prev = move.prev;
                move.prev = baru;
            }
        }
    }

public void kiri()
{
    if(status==0)
    {
        status=1;
    }
    else if(move.prev != null);
    {
        move = move.prev;
    }
}
 
public void kanan()
{
   if(status==1)
   {
       status = 0;
   }
   else if(move.next != null)
   {
       move = move.next;
   }
}

public void icetak()
{
    cetak=head;
    if(head==null)
    {
        System.out.println("Data Karakter Kosong !");
    }
    System.out.println("Kata : ");
    while(cetak != null)
    {
        System.out.print(" "+cetak.huruf);
        cetak = cetak.next;
    }
    System.out.println(" ");
}
public void ihapus()
{
    if(status == 0)
    {
        hapus = move;
        System.out.println("Karakter Sudah di hapus");
        if(move == head)
        {
            move = move.next;
            hapus = head;
            head = move;
            if(head != null)
                head.prev=null;   
        }
        else 
        {
            move = move.prev;
            move.next = hapus.next;
            if(hapus.next != null)
                hapus.next.prev = move;
        }
    }
    else if(move != head)
    {
        hapus = move.prev;
        System.out.println("Karakter Sudah di hapus");
        {
            if(hapus.prev != null)
            {
                hapus.prev.next = move;
                move.prev = hapus.prev;
            }
            else 
            {
                move.prev = null;
                head = move;
            }
        }
    }
}

public static void main(String[] args)
{
    Editingtext editingtext = new Editingtext();
    Scanner scan = new Scanner(System.in);
    int maks=0;
    System.out.println("Jumlah inputan ");
    int jmlh = scan.nextInt();
    
    while(maks<jmlh)
    {
        System.out.println("Pilih Menu Di Bawah Ini");
        System.out.println("1. Printf");
        System.out.println("2. ADD");
        System.out.println("3. Delete Text");
        System.out.println("4. Shift_left");
        System.out.println("5. Shift_right");
        System.out.println("Ketik Pilihan : ");
        int pil = scan.nextInt();
        if(pil==1)
        {
           editingtext.icetak();
        }
        else if(pil==2)
        {
            System.out.println("Masukan kata : ");
            char huruf = scan.next().charAt(0);
            editingtext.tambah();
        }
        else if(pil==3)
        {
            editingtext.ihapus();
        }
        else if(pil==4)
        {
            editingtext.kiri();
        }
        else if(pil==5)
        {
            editingtext.kanan();
        }
        maks++;
    }  
}
}
