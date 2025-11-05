import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static Map<Integer, Map.Entry<String, int[]>> invitedPeople;
	static Map<Integer, Map.Entry<String, int[]>> celebrities;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        invitedPeople = new HashMap<>();

        createInvitedPerson(1,"Albert",2,5,6);
        createInvitedPerson(2,"Bénédicte",3,5,6);
        createInvitedPerson(3,"Christophe",2,4,5,6);
        createInvitedPerson(4,"Delphine",1,2,5,6,8);
        createInvitedPerson(5,"Edouard",6);
        createInvitedPerson(6,"Françoise",5);
        createInvitedPerson(7,"Gaston",2,3,5,6,8);
        createInvitedPerson(8,"Heloïse",2,4,5,6,7);


        //get celebrities list
        celebrities = findCelebrities(invitedPeople);
        
        //print area
        System.out.print("Les celebrités sont ");
        for(Map.Entry<Integer, Map.Entry<String, int[]>> celebrity : celebrities.entrySet()) {
        	System.out.print(celebrity.getValue().getKey()+", ");
        }
	}

	
	/**
	 * Function to create desired people, this function will create and insert the invited people into the list
	 * @param number the number associated the the invited
	 * @param name his name
	 * @param int[]... the people's index that he knows
	 */
	public static void createInvitedPerson(int number, String name, int... knownPeople) {
		//create a entry
		Map.Entry<String, int[]> person = new AbstractMap.SimpleEntry<>(name,knownPeople);
		//insert into list
		invitedPeople.put(number,person);
	}
	
	
	/**
	 * Fonction to apply the filters and add celebrities
	 * @param invitedPeopleList the list of invited people
	 * @return list of celebrities
	 */
	public static Map<Integer, Map.Entry<String, int[]>> findCelebrities(Map<Integer, Map.Entry<String, int[]>> invitedPeopleList) {
		//celebrity list
		Map<Integer, Map.Entry<String, int[]>> celebrityList = new HashMap<>();
		
		//-----STEP 1 : CHECK IF EVERYONE KNOWS HIM-----
		//go throught all people
		for(Map.Entry<Integer,Map.Entry<String, int[]>> thePossibleCelebrity : invitedPeopleList.entrySet()) {
			boolean possiblyACelebrity = true;
			
			//check if he's known by everyone
			for(Map.Entry<Integer,Map.Entry<String, int[]>> personToCheckIfKnownsHim : invitedPeopleList.entrySet()) {
				//if not the same guy?
				if(!thePossibleCelebrity.equals(personToCheckIfKnownsHim)) {
					//get list of known people
					List<Integer> knownPeople = convertPrimitiveListToOOP(personToCheckIfKnownsHim.getValue().getValue());
					
					//if not in list so our guy us not the celebrity
					if(!knownPeople.contains(thePossibleCelebrity.getKey())){
						possiblyACelebrity = false;
						break;
					}
				}
			}
			if(possiblyACelebrity) {
				celebrityList.put(thePossibleCelebrity.getKey(),thePossibleCelebrity.getValue());
			}
		}
		
		//-----STEP 2 : VERIFY IF THEY KNOW EACH OTHER-----
		//for each celebrity
		ArrayList<Integer> notCelebrities = new ArrayList<>();
		for(Map.Entry<Integer,Map.Entry<String, int[]>> celebrityToCheck : celebrityList.entrySet()) {
			//go throught 
			//for each person that he knows go
			for(int i : celebrityToCheck.getValue().getValue()) {
				if(!celebrityList.containsKey(i)) {
					notCelebrities.add(celebrityToCheck.getKey());
				}
			}
		}
		//remove indexes
		for(int i : notCelebrities) {
			celebrityList.remove(i);
		}
		return celebrityList;
	}
	
	
	/**
	 * Function to convert a primitive int list ( int[] ) into oop list List<Integer
	 * @param the primitive list
	 * @return the oop list
	 */
	public static List<Integer> convertPrimitiveListToOOP(int[] primitiveList){
		//create the oop
		List<Integer> localList = new ArrayList<>();
		//for each element in the primitive list
		for (int e : primitiveList) {
			//add to the oop list
			localList.add(e);
		}
		
		//return 
		return localList;
		
	}
}
