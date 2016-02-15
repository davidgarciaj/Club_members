import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // List of Club´s members
    private ArrayList<Membership> members;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // List members
        members = new ArrayList<>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        members.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {        
        return members.size();
    }
    
    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int month){
        int cont = 0;
        if(month > 0 && month < 13){
            for(Membership member: members){
                if(member.getMonth() == month){cont++;}
            }
        }
        else{
            System.out.println("El número introducido no pertenece a un mes.");
        }
        return cont;
    }
    
    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList<Membership> purge(int month, int year){
        ArrayList<Membership> bajas = new ArrayList<>();
        if(month > 0 && month < 13){
            Iterator<Membership> it = members.iterator();
            while(it.hasNext()){
                Membership member = it.next();
                if(member.getMonth() == month && member.getYear() == year && member != null){
                    bajas.add(member);
                    it.remove();
                }
            }
        }
        else{
            System.out.println("El número introducido no pertenece a un mes.");
        }
        return bajas;
    }
}
