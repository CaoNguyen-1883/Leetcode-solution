select firstName, lastName, city, state
from 
    Person  p left join Address on p.personId = Address.personId; 