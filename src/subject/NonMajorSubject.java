package subject;

import java.util.Scanner;

import exceptions.RankingException;

public abstract class NonMajorSubject extends Subject {

	public NonMajorSubject(SubjectKind kind) {
		super(kind);
	}
	public abstract void printInfo();

	public abstract void getUserInput(Scanner sc);

	public void setProfessorwithYN(Scanner sc) {
		char answer='x';
		while(answer!='Y'||answer!='y'||answer!='n'||answer!='N') {
			System.out.print("Need to review it soon?(Y/N): ");	//�����̹Ƿ� ���� ������ �ʿ䰡 �ִ��� ����
			answer=sc.next().charAt(0);

			if(answer=='Y' || answer=='y') {
				while(true) {
					try {
						System.out.print("*Review ranking(Natural num): ");
						this.setRrank(sc.nextInt());
						break;
					}
					catch(RankingException e) {
						System.out.println("\n!!Input an natural number!!\n");
					}
				}
				break;
			}

			else if(answer=='N' || answer=='n') {
				try {
					this.setRrank(Integer.MAX_VALUE);
				} catch (RankingException e) {
				}
				break;
			}
			else {
				System.out.println("\n!!Input Y/N!!");
			}
		}

	}
}
