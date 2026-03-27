import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        List<Record> records = new ArrayList<>();
        Record country = null;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Record record = new Record(
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())
            );
            records.add(record);
            if (record.countryIndex == k) {
                country = record;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (records.get(i) == country) {
                continue;
            }
            if (country.lose(records.get(i))) {
                count++;
            }
        }
        System.out.println(count + 1);
    }

    private static class Record {
        int countryIndex;
        int gold;
        int silver;
        int bronze;

        public Record(int countryIndex, int gold, int silver, int bronze) {
            this.countryIndex = countryIndex;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean lose(Record other) {
            if (this.gold == other.gold) {
                if (this.silver == other.silver) {
                    return this.bronze < other.bronze;
                }
                return this.silver < other.silver;
            }
            return this.gold < other.gold;
        }
    }
}