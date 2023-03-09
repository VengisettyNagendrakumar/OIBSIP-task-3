// the atm interface

import java.util.*;

class Node {
    int amount  =0;
    int accountNumber = 0;
    int password;
    List<String> list = new LinkedList<>();
    public Node(int amount,int accountNumber,int password) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.password = password;
    }
}
class solution {
    HashMap<String,Node> map;
    public solution() {
        map  = new HashMap<>();
        map.put("ravi",new Node(500,1234567323,1234));
        map.put("dileep",new Node(1000,2143234132,4324));
    }

    public void sol() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username");
        String s = scanner.nextLine();
        if(this.map.containsKey(s)) {
            System.out.println("Enter the password");
            int pass = this.map.get(s).password;
            int passE = scanner.nextInt();
            if(pass == passE) {
                while (true) {
                    List<String> li = this.map.get(s).list;
                    System.out.println("1.Transaction History\t" + "2.Withdraw\t" + "3.Deposit\t" + "4.Transfer\t" + "5.amount\t" + "6.Quit");
                    int number = scanner.nextInt();
                    if (number == 1) {
                        if (li.isEmpty()) {
                            System.out.println("No transaction have been made");
                        } else {
                            for (String c : li) {
                                System.out.println(c);
                            }
                        }
                    } else if (number == 2) {
                        System.out.println("Enter the money to withdraw");
                        int draw = scanner.nextInt();
                        if (draw <= this.map.get(s).amount) {
                            this.map.get(s).amount -= draw;
                            System.out.println(draw + "has been debited from your account");
                            String c = "Money withdraw" + draw;
                            li.add(c);
                        } else {
                            System.out.println("The amount you entered is more than you have");
                        }
                    } else if (number == 3) {
                        System.out.println("enter the amount to be deposited");
                        int deposit = scanner.nextInt();
                        this.map.get(s).amount += deposit;
                        String c = "Money deposited" + deposit;
                        li.add(c);
                        System.out.println("Successfully amount deposited");
                    } else if (number == 4) {
                        System.out.println("Enter the amount to be transferred");
                        int transfer = scanner.nextInt();
                        System.out.println("enter the username of the receiver");
                        String username = scanner.next();
                        if(this.map.containsKey(username)) {
                            if (transfer <= this.map.get(s).amount) {
                                this.map.get(s).amount -= transfer;
                                this.map.get(username).amount += transfer;
                                System.out.println("Successfully money transfer to the account number" + this.map.get(username).accountNumber);
                                li.add("Successfully money transfer to the account number" + this.map.get(username).accountNumber);
                            }
                            else {
                                System.out.println("transferring amount is more than you had");
                            }
                        }
                        else {
                            System.out.println("there is no member with username" + username);
                        }

                    }
                    else if(number == 5) {
                        System.out.println("the current amount" + "\t" + this.map.get(s).amount);
                    }
                    else if (number == 6) {
                        break;
                    }
                    else {
                        System.out.println("Please select the number which is in the given range");
                    }
                }
            }
            else {
                System.out.println("you entered wrong number");
            }
        }
    }
}
class sol {
    public static void main(String[] args) {
        solution n =new solution();
        n.sol();
    }
}



