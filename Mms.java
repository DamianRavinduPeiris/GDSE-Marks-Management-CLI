import java.util.*;
	class Student{
		 String id;
		 String name;
		 double prfmarks;
		 double dbmsmarks;
		 double total;
		 double average;
		Student(){
			id = null;
			name = null;
			prfmarks = -1;
			dbmsmarks = -1;
			total = -1;
			average = -1; 
		}
		public void setid(String i){
			this.id = i;
		}
		public void setname(String n){
			this.name = n;
		}
		public void setprf(double p){
			this.prfmarks = p;
		}
		public void setdbms(double d){
			this.dbmsmarks = d;
		}
		public void settotal(double p,double d){
			this.total = p+d;
		}
		public void setaverage(double average){
			this.average =average;
		}
		public String getid(){
			return this.id;
		}
		public String getname(){
			return this.name;
		}
		public double getprf(){
			return this.prfmarks;
		}
		public double getdbms(){
			return this.dbmsmarks;
		}
		public double gettotal(){
			return this.total;
		}
		public double getaverage(){
			return this.average;
		}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Mms{
		public static Student [] sd = new Student [0]; 
		public static double [] avgarray = new double [0];
		public static double [] prfarray = new double [0];
		public static double [] dbmsarray = new double [0];
		public final static void clearConsole() {	//Method to clear the console.
		try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		}
		} catch (final Exception e) {
		e.printStackTrace();
		// Handle any exceptions.
		}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static boolean checkid(String id){
				boolean IsExists = false;
				for (int i = 0; i <sd.length; i++){
					if(sd[i].id.equals(id)){
						IsExists = true;
						return IsExists;
					}
				}
				return IsExists;
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static void addnewstudent(){
			Scanner input = new Scanner(System.in);
			boolean IsExists  = false;
			int num = 0;
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|\t\t\tAdd a new Student.                	  |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println();
			double average = -1;
			double prf = -1;
			double dbms = -1;
			System.out.print("Enter Student ID : ");
			String id = input.nextLine();
			IsExists = checkid(id);
				if(IsExists==false){
					Student S = new Student();
					S.setid(id);
					num=getelementno(id);
					System.out.print("Enter student name  : ");
					String name = input.nextLine();
					S.setname(name);
					Student [] tempsd = new Student [sd.length+1]; 
					for (int i = 0; i <sd.length; i++){
						tempsd [i] = sd [i];
					}
					sd = tempsd;
					sd [sd.length-1] = S;
					double [] tempprf = new double [prfarray.length+1];
					double [] tempdbms = new double [dbmsarray.length+1];
					double [] tempavg = new double [avgarray.length+1];
					for (int i = 0; i <prfarray.length; i++){
						tempprf[i] = prfarray[i];
						tempdbms[i] = dbmsarray[i];
						tempavg[i] = avgarray[i];
					}
					prfarray = tempprf;
					prfarray [prfarray.length-1] = -1;
					dbmsarray = tempdbms;
					dbmsarray [dbmsarray.length-1] = -1;
					avgarray = tempavg;
					avgarray [avgarray.length-1] = -1;
					System.out.println();
					System.out.print("Student added sucessfully!,Do you want to add another student ?(Y/N) : ");
					String option = input.nextLine();
					if (option.equals("Y")||option.equals("y")){
					clearConsole();
					addnewstudent();
					}
					else{
					clearConsole();
					main(null);
					}
				}
				else{
						System.out.println();
						System.out.print("Student ID is duplicated!,Do you want to try again? (Y/N) :  ");
						String option = input.nextLine();
						if (option.equals("Y")||option.equals("y")){
							clearConsole();
							addnewstudent();
						}
						else{
							clearConsole();
							main(null);
						}	
				}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		public static int marksvalidator(double marks){
			Scanner input = new Scanner (System.in);
			int num = 1;
			if(marks>101 || marks<0){
				System.out.print("Invalid marks!,Do you want to try again? (Y/N) : ");
				String option = input.nextLine();
				if(option.equals("Y")||option.equals("y")){
					clearConsole();
					studentwithmarks();
				}
				else{
					clearConsole();
					main(null);
				}
			}
			return num;
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void studentwithmarks(){
			Scanner input  = new Scanner(System.in);
			int num = 0;
			int index = 0;
			boolean IsExists = false;
			double total = 0;
			double average = 0;
			System.out.print("+-----------------------------------------------------------------------------+");
			System.out.println();
			System.out.println("|\t\t\t\tAdd a new Student with marks.          	      |");
			System.out.print("+-----------------------------------------------------------------------------+");
			System.out.println();
			System.out.print("Enter Student ID : ");
			String id = input.nextLine();
			IsExists = checkid(id);
				if(IsExists==false){
					Student T = new Student();
					T.setid(id);
					index = getelementno(id);
					System.out.print("Enter Student name : ");
					String name = input.nextLine();
					T.setname(name);	
					System.out.print("Enter PRF marks : ");
					double prf = input.nextDouble();
					 num = marksvalidator(prf);
					if(num==1){
						T.setprf(prf);
					}
					System.out.print("Enter DBMS marks : ");
					double dbms = input.nextDouble();
					 num = marksvalidator(dbms);
					if(num==1){
					T.setdbms(dbms);
					T.settotal(prf,dbms);
					total = prf+dbms;
					average = total/2;
					T.setaverage(average);
					}
					Student [] tempsd = new Student [sd.length+1]; 
					for (int i = 0; i <sd.length; i++){
						tempsd [i] = sd[i];
					}
					sd = tempsd;
					sd [sd.length-1] = T;
					double [] tempprf = new double [prfarray.length+1];
					double [] tempdbms = new double [dbmsarray.length+1];
					double [] tempavg = new double [avgarray.length+1];
					for (int i = 0; i <prfarray.length; i++){
						tempprf[i] = prfarray[i];
						tempdbms[i] = dbmsarray[i];
						tempavg[i] = avgarray[i];
					}
					prfarray = tempprf;
					prfarray [prfarray.length-1] = prf;
					dbmsarray = tempdbms;
					dbmsarray [dbmsarray.length-1] =dbms;
					avgarray = tempavg;
					avgarray [avgarray.length-1] = average;
					System.out.println();
					System.out.print("Student added sucessfully!Do you want to add another student? (Y/N) : ");
					String option = input.next();
					if(option.equals("Y")||option.equals("y")){
						clearConsole();
						studentwithmarks();
					} 
					else{
						clearConsole();
						main(null);
					}
				}
				else{
					System.out.print("Student ID is duplicated!Do you want to try again? (Y/N): ");
					String option = input.next();
					if (option.equals("Y")||option.equals("y")){
						clearConsole();
						studentwithmarks();
					}
					else{
						clearConsole();
						main(null);
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		public static int getelementno(String id){
			int num = 0;
			for (int i = 0; i <sd.length; i++){
					if(sd[i].id.equals(id)){
						num = i;
						return num;
					}
				}
			return num;	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static void addmarksusingid(){
			Scanner input = new Scanner (System.in);
			boolean IsExists = false;
			int num = 0;
			double total = 0;
			double average = 0;
			System.out.print("+-----------------------------------------------------------------------------+");
			System.out.println();
			System.out.println("|\t\t\t\tAdd marks using id.                           |");
			System.out.println("+-----------------------------------------------------------------------------+");
			System.out.println();
			System.out.print("Enter student ID : ");
			String id = input.nextLine();
			IsExists = checkid(id);
				if (IsExists==true){
					num = getelementno(id);
					System.out.println("Student Name : "+sd[num].getname());
					if (sd[num].prfmarks>0){
						System.out.print("This students marks have been already added! Do you want to try again using differnt Student ID ? (Y/N) :");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
							clearConsole();
							addmarksusingid();
						}
						else{
							clearConsole();
							main(null);
						}
					}
					else{
					System.out.print("Enter PRF marks : ");
					double prf = input.nextDouble();
					int	marks = marksvalidator(prf);
					if (marks==1){
						sd[num].setprf(prf);
					}
					System.out.print("Enter DBMS marks : ");
					double dbms = input.nextDouble();
					 marks = marksvalidator(prf);
					if (marks==1){
						sd[num].setdbms(dbms);
						sd[num].settotal(prf,dbms);
						total = prf+dbms;
						average = total/2;
						sd[num].setaverage(average);
						prfarray[num] = prf;
						dbmsarray[num] = dbms;
						avgarray[num] = average;
					}
					System.out.println();
					System.out.print("Marks have been added sucessfully! Do you want to add another student's marks? (Y/N) : ");
					String option = input.next();
					if (option.equals("Y")||option.equals("y")){
						clearConsole();
						addmarksusingid();
					} 
					else{
						clearConsole();
						main(null);
					}
				}
				}
				else{
					System.out.print("Student ID not found! Do you want to search again? (Y/N)");
					String option = input.next();
					if (option.equals("Y")||option.equals("y")){
						clearConsole();
						addmarksusingid();
					} 
					else{
						clearConsole();
						main(null);
					}
				}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void updatename(){
			Scanner input = new Scanner(System.in);
			boolean IsExists = false;
			int num = 0;
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\tUpdate student name.                               			       |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println();
			System.out.print("Enter Student ID : ");
			String id = input.nextLine();
			IsExists = checkid(id);
				if (IsExists==true){
					num = getelementno(id);
					System.out.println("Student name : "+sd[num].getname());
					System.out.print("Enter the new name : ");
					String name = input.nextLine();
					sd[num].setname(name);
					System.out.print("Student details have been updated sucessfully!Do you want to update another student? (Y/N) : ");
					String option = input.next();
					if (option.equals("Y")||option.equals("y")){
						clearConsole();
						updatename();
					}
					else{
						clearConsole();
						main(null);
					}					
				}
				else{
					System.out.print("Student ID not found!Do you want to search again? (Y/N) :  ");
					String option = input.next();
					if (option.equals("Y")||option.equals("y")){
						clearConsole();
						updatename();
					}
					else{
						clearConsole();
						main(null);
					}			
				}
		}	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void updatemarks(){
				Scanner input = new Scanner (System.in);
				boolean IsExists = false;
				int num = 0;
				int marks = 0;
				double total = 0;
				double average = 0;
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\tUpdate student marks.                               			       |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println();
				System.out.print("Enter Student ID : ");
				String id = input.nextLine();
				IsExists = checkid(id);
					if (IsExists==true){
						num = getelementno(id);
						System.out.println("Student Name : "+sd[num].getname());
						System.out.println("PRF  Marks   : "+sd[num].getprf());
						System.out.println("DBMS Marks:  : "+sd[num].getdbms());
						System.out.print("Input new PRF marks : ");
						double prf = input.nextDouble();
						marks = marksvalidator(prf);
							if (marks==1){
								sd[num].setprf(prf);
							}
						System.out.print("Input new DBMS marks : ");
						double dbms = input.nextDouble();
						marks = marksvalidator(dbms);
							if (marks==1){
								sd[num].setdbms(dbms);
								sd[num].settotal(prf,dbms);
								total = prf+dbms;
								average = total/2;
								sd[num].setaverage(average);
								prfarray[num] = prf;
								dbmsarray[num] = dbms;
								avgarray[num] = average;
							}	
							System.out.println();
							System.out.print("Student marks have been updated sucessfully!,Do you want to update anothe student? (Y/N) : ");
							String option = input.next();
							if (option.equals("Y")||option.equals("y")){
							clearConsole();
							updatemarks();
							}
							else{
							clearConsole();
							main(null);
							}	
					}
					else{
						System.out.print("Student ID not found!Do you want to search again? (Y/N) : ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						updatemarks();
						}
						else{
						clearConsole();
						main(null);
						}
					}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void deletestudent(){
			Scanner input = new Scanner (System.in);
				boolean IsExists = false;
				int num = 0;
				int marks = 0;
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\tDelete Student.                               			          			|");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.print("Enter Student ID : ");
				String id = input.nextLine();
				IsExists = checkid(id);
					if (IsExists==true){
						num = getelementno(id);
						Student [] tempstudent = new Student [sd.length-1];
						double [] tempprf = new double [prfarray.length-1];
						double [] tempdbms = new double [dbmsarray.length-1];
						double [] tempavg = new double [avgarray.length-1];
						for (int i = num; i <sd.length-1; i++){
							sd [i] = sd [i+1]; 
							tempprf [i] = tempprf [i];
							tempdbms [i] = tempdbms [i];
							tempavg [i] = tempavg [i];
						}
						for (int i = 0; i <sd.length-1; i++){
							tempstudent [i] = sd [i];
							tempprf [i] = prfarray[i];
							tempdbms [i] = dbmsarray [i];
							tempavg [i] = avgarray [i];
						}
						sd = tempstudent;
						prfarray = tempprf;
						dbmsarray = tempdbms;
						avgarray = tempavg;
						System.out.println();
						System.out.print("Student deleted sucessfully!Do you want to delete another student? (Y/N) : ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						deletestudent();
						}
						else{
						clearConsole();
						main(null);
						}
					}
					else{
						System.out.print("Student ID not found!Do you want to search again? (Y/N) : ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						deletestudent();
						}
						else{
						clearConsole();
						main(null);
						}
					}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void printdetails(){
			Scanner input = new Scanner (System.in);
				boolean IsExists = false;
				int num = 0;
				int marks = 0;
				int rank = 0;
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|\t\t\tView Student details.                               			       |");
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.print("Enter Student ID : ");
				String id = input.nextLine();
				IsExists = checkid(id);
				if(IsExists==true){
					num = getelementno(id);
					if (sd[num].prfmarks==-1){
						System.out.print("Marks of this student is yet to be added.Do you want to search again? (Y/N) : ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						printdetails();
						}
						else{
						clearConsole();
						main(null);
						}
					}
					else{
						System.out.println();
						System.out.println("Student ID   : "+sd[num].getid());
						System.out.println("Student Name : "+sd[num].getname());
						System.out.println("PRF Marks    : "+sd[num].getprf());
						System.out.println("DBMS MARKS   : "+sd[num].getdbms());
						System.out.println("Total Marks  : "+sd[num].gettotal());
						System.out.println("Average Marks :"+sd[num].getaverage());
						for (int i = 0; i <avgarray.length-1; i++){
							for (int j = 0; j <avgarray.length-1; j++){
								if (avgarray[j]<avgarray[j+1]){
									double temp1 = avgarray[j+1];
									avgarray[j+1] = avgarray[j];
									avgarray[j] = temp1;
									Student temp2 = sd[j+1];
									sd[j+1] = sd[j];
									sd[j] = temp2;
								}
							}
						}
						for (int i = 0; i <sd.length; i++){
							if (sd[i].id.equals(id)){
								rank = i;
								System.out.println("Rank    	:	"+(rank+1));
							}
						}
						System.out.println("+------------------------------------------------------------------------------------------------------+");
						System.out.println();
						System.out.print("Do you want to view details of another student? (Y/N) :  ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						printdetails();
						}
						else{
						clearConsole();
						main(null);
						}
					}
				}
				else{
					System.out.print("Student ID not found!Do you want to search again? (Y/N) : ");
						String option = input.next();
						if (option.equals("Y")||option.equals("y")){
						clearConsole();
						printdetails();
						}
						else{
						clearConsole();
						main(null);
						}
				}	
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static void printranks(){
			Scanner input = new Scanner(System.in);
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\tStudent Ranks.                                                                |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|Rank.\t|Student ID.\t|Name.\t|Total Marks.\t|Average Marks.                                       |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
						for (int i = 0; i <avgarray.length-1; i++){
							for (int j = 0; j <avgarray.length-1; j++){
								if (avgarray[j]<avgarray[j+1]){
									double temp1 = avgarray[j+1];
									avgarray [j+1] = avgarray[j];
									avgarray [j] = temp1;
									Student temp2 = sd [j+1];
									sd [j+1] = sd[j];
									sd[j] = temp2;
								}
							}
						} 
			 L1: for (int i = 0; i <sd.length; i++){
					if(sd[i].prfmarks==-1){
						break;
					}
					System.out.print((i+1));
					for(int j=i;j<=i;j++){
					if(sd[j].prfmarks==-1){
						continue L1;
					}
					System.out.println("\t"+sd[j].getid()+"\t\t"+sd[j].getname()+"\t\t"+sd[j].gettotal()+"\t\t"+sd[j].getaverage());
					}
			}
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println();
				System.out.print("Do you want to go back to main menu? (Y/N):");
				String option = input.next();
				if (option.equals("Y")||option.equals("y")){
						clearConsole();
						main(null);
						}
						else{
						clearConsole();
						printranks();
						}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static void bestprf(){
		Scanner input = new Scanner(System.in);	
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|\t\t\tBest in Programming Fundamentals. (PRF)                                        |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i <prfarray.length-1; i++){
			for (int j = 0; j <prfarray.length-1; j++){
				if (prfarray[j]<prfarray[j+1]){
					double temp1 = prfarray[j+1];
					prfarray[j+1] = prfarray[j];
					prfarray[j] = temp1;
					Student temp2 = sd [j+1];
					sd [j+1] = sd [j];
					sd [j] = temp2;
				}
			}	
		}
		System.out.println("+-----------------------------------------------------+");
		System.out.println("Student ID.\t|Name.\t|PRF Marks.\t|DBMS Marks.  |");
		System.out.println("+----------------------------------------------------+");
	L1:	for (int i = 0; i <sd.length; i++){
			if(sd[i].prfmarks==-1){
				continue L1;
			}
			System.out.println(sd[i].getid()+"\t\t|"+sd[i].getname()+"\t\t|"+sd[i].getprf()+"\t\t|"+sd[i].getdbms()+"|");	
		}
		System.out.println("+----------------------------------------------------+");
		System.out.println();
				System.out.print("Do you want to go back to main menu? (Y/N):");
				String option = input.next();
				if (option.equals("Y")||option.equals("y")){
						clearConsole();
						main(null);
						}
						else{
						clearConsole();
						bestprf();
						}	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		public static void bestdbms(){
		Scanner input = new Scanner(System.in);	
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("|\t\t\tBest in Database Management Systems. (DBMS)                                    |");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
				for (int i = 0; i <dbmsarray.length-1; i++){
			for (int j = 0; j <dbmsarray.length-1; j++){
				if (dbmsarray[j]<dbmsarray[j+1]){
					double temp1 = dbmsarray[j+1];
					dbmsarray[j+1] = dbmsarray[j];
					dbmsarray[j] = temp1;
					Student temp2 = sd [j+1];
					sd [j+1] = sd [j];
					sd [j] = temp2;
				}
			}	
		}
		System.out.println("+-----------------------------------------------------+");
		System.out.println("Student ID.\t|Name.\t|DBMS Marks.\t|PRF Marks.  |");
		System.out.println("+----------------------------------------------------+");
	L1:	for (int i = 0; i <sd.length; i++){
			if(sd[i].prfmarks==-1){
				continue L1;
			}
			System.out.println(sd[i].getid()+"\t\t|"+sd[i].getname()+"\t\t|"+sd[i].getdbms()+"\t\t|"+sd[i].getprf()+"|");	
		}
		System.out.println("+----------------------------------------------------+");
		System.out.println();
				System.out.print("Do you want to go back to main menu? (Y/N):");
				String option = input.next();
				if (option.equals("Y")||option.equals("y")){
						clearConsole();
						main(null);
						}
						else{
						clearConsole();
						bestprf();
						}	
				
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static void main (String args [] ){   //Main Method.
			Scanner input  = new Scanner(System.in);
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\tWelcome to GDSE marks management system.                                       |");
			System.out.println("+------------------------------------------------------------------------------------------------------+");
			System.out.println();
			System.out.println();
			System.out.print("1. Add new student. ");
			System.out.println("\t\t\t2. Add new student with marks. ");
			System.out.print("3. Add marks."); 
			System.out.println("\t\t\t\t4. Update student details.");
			System.out.print("5. Update marks.");
			System.out.println("\t\t\t6. Delete student.");
			System.out.print("7. Print student details.");
			System.out.println("\t\t8. Print student ranks.");
			System.out.print("9. Best in PRF.");
			System.out.println("\t\t\t\t10. Best in DBMS.");
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int option  = input.nextInt();
			clearConsole();
			 switch(option){
				case 1 	: addnewstudent();	break;
				case 2	: studentwithmarks();	break;
				case 3 	: addmarksusingid ();break;
				case 4  : updatename();break;
				case 5  : updatemarks();break;
				case 6 	: deletestudent();break;
				case 7 	: printdetails();break;
				case 8	: printranks();	break;
				case 9  : bestprf();break;
				case 10 : bestdbms();break;
				default	: System.out.println("Invalid option ! try again.");
				main(null);
				}
		}
	}
