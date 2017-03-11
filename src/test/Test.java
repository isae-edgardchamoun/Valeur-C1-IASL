package test;

import java.io.File;
import java.util.Map;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Test {
    private static final File DB_PATH = new File( "C:\\Users\\User\\Documents\\Neo4j\\default.graphdb" );
    
    public static void main(String[] args) {
        try
        {
            GraphDatabaseFactory graphDb = new GraphDatabaseFactory();
            GraphDatabaseService serv = graphDb.newEmbeddedDatabase(DB_PATH);
            Result r = serv.execute("MATCH (e:etudiant) RETURN e.etudiantNom");
            while(r.hasNext()){
                Map<String, Object> row = r.next();
                for ( String key : r.columns() )
                {
                    System.out.println( "Nom Etudiant : " + row.get( key ) );
                }
            }
            r.close();
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
