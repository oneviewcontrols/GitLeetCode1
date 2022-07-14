package com.company.leetcode.problems;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class IndeedTest {

    public class Solution {

        private Map<Integer, Set<String>> map = new HashMap<Integer,Set<String>>();


        public void storeDocument(final String document, final int documentNumber) {
            String[] words = document.split(" ");
            Set<String> set = new HashSet<String>();
            for (String word : words) {
                set.add(word);
            }
            map.put(documentNumber,set);
        }

        public String performSearch(final String search) {
            String[] terms = search.split(" ");
            Map<Integer, List<Integer>> matchCountsMap = new HashMap<Integer,List<Integer>>();
            int jobs = map.size();
            int count = 0;
            for (String term : terms) {
                for (int i=0;i<jobs;i++) {
                    Set<String> jobWords = map.get(i);
                    System.out.println("DESCRIPTION = " + jobWords + " SEARCH " + term);
                    if (jobWords.contains(term)) {
                        count++;
                        if (matchCountsMap.containsKey(count)) {
                            matchCountsMap.get(count).add(i);
                        } else {
                            List<Integer> jobIds = new ArrayList<Integer>();
                            jobIds.add(i);
                            matchCountsMap.put(count,jobIds);
                        }
                    }
                    System.out.println("Count = " + count);
                    count = 0;
                }
            }
            List<Integer> results = new ArrayList<Integer>(matchCountsMap.keySet());
            Collections.sort(results);
            StringBuilder builder = new StringBuilder();
            System.out.println("-------------------------");
            for (Integer result : results) {
                List<Integer> jobIds = matchCountsMap.get(result);
                Collections.sort(jobIds);
                for (Integer j : jobIds) {
                    ///System.out.println("Job Ids = " + j);
                    builder.append(j + " ");
                }
            }
            //System.out.println("-------------------------");


            return builder.toString();
        }















        /*
        Optimization notes: Due to hackerrank global timeout definitions per language, programs
        except for the most optimized will have a tough time passing the last test case.
        This is known and you will not be penalized for it.
         */
//        public static void main(String args[] ) throws Exception {
//            // Read input from STDIN. Print output to STDOUT
//            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            final int N = Integer.parseInt(br.readLine());
//            // Read documents
//            for (int i = 0; i < N; i++) {
//                storeDocument(br.readLine(), i);
//            }
//
//            final BufferedOutputStream output = new BufferedOutputStream(System.out);
//
//            final int M = Integer.parseInt(br.readLine());
//            // Read searches
//            for (int j = 0; j < M; j++) {
//                output.write((performSearch(br.readLine()) + "\n").getBytes());
//            }
//
//            output.flush();
//
//            output.close();
//            br.close();
//        }
    }
}
