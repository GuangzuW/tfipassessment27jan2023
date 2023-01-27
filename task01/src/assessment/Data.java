package assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {

    private List<String> words;
    private List<Integer> wordCounts;
    private int totalWordCounts;

    public Data() {
        this.words=new ArrayList<>();
        this.wordCounts=new ArrayList<>();
        this.totalWordCounts=0;
    }

    public Data(List<String> words, List<Integer> wordCounts, int totalWordCounts) {
        this.words = words;
        this.wordCounts = wordCounts;
        this.totalWordCounts = totalWordCounts;
    }

    

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<Integer> getWordCounts() {
        return wordCounts;
    }

    public void setWordCounts(List<Integer> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public int getTotalWordCounts() {
        return totalWordCounts;
    }

    public void setTotalWordCounts(int totalWordCounts) {
        this.totalWordCounts = totalWordCounts;
    }



    public Data getData(Data data, String fileName) throws IOException{
        
        String dirPath="testfilefolder";
        File newDirectory=new File(dirPath);

        String filePath=dirPath+File.separator+fileName;
        File file=new File(filePath);;

        if(!newDirectory.exists()){
            newDirectory.mkdirs();
            System.out.println(dirPath+" not exist, new directory created");
        }

        String[] ignore={".",",",":","!","-","(",")","{","}","\"","\"","?","—",";","\'"};
        
        if(!file.exists()){
            System.out.println(fileName+" not exist, please check the name of file and place it inside testfilefolder...");
        }else{

            BufferedReader br=new BufferedReader(new FileReader(file));
            String line="";
            //read and process data
            while ((line=br.readLine())!=null){
                //ignore sign
                for (int i=0;i<ignore.length;i++){
                    line=line.replace(ignore[i],"");
                }
                line=line.trim().toLowerCase();
                String[]splitedLine=line.split(" ");
                //look for contain in the list words, if word in the splitedline inside the words list, the word totalcount and coresponding wordcount +1
                //if not in the words list, add the word in the words list and set the coressponding the wordcounts to 1
                for (int j=0;j<splitedLine.length;j++){
                    boolean wordFound=false;
                    if(data.words==null){
                        data.words.add(" ");
                        data.wordCounts.add(0);
                    }
                    for(int k=0;k<data.words.size();k++){
                        if(splitedLine[j].equalsIgnoreCase(data.words.get(k))){
                            wordFound=true;
                            int IndexOfWord=data.words.indexOf(splitedLine[j].trim());
                            data.wordCounts.set(IndexOfWord, data.wordCounts.get(IndexOfWord)+1);
                            data.totalWordCounts++;
                            break;
                        }     
                    }
                    if(!wordFound){
                        if(splitedLine[j]==""){continue;}
                        data.words.add(splitedLine[j]);
                        data.wordCounts.add(1);
                        data.totalWordCounts++;
                    }    
                }
                
            }
            br.close();
            
        }
        return data;

    }

    public void printTop10 (Data data){

        List<Integer>copyWordCounts=new ArrayList<>(data.wordCounts);
        List<String>copyWords=new ArrayList<>(data.words);
        int previousmax=-1;
        int limit=0;
        int max=0;

        for(int i=0;i<copyWordCounts.size()&limit<10;i++){

                max=Collections.max(copyWordCounts);
                if(previousmax!=max){limit++;}
                int index=copyWordCounts.indexOf(max);
                copyWordCounts.remove(index);
                String word= copyWords.get(index);
                copyWords.remove(index);
                double frequency=(double)max/data.totalWordCounts;
                previousmax=max;
                System.out.printf("Top %d frequency word is: \"%s\", it appears %d times, and frequency is %.3f .",limit,word,max,frequency);
                System.out.println();
        }
    }

}
