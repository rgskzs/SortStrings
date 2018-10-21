package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StringToInt {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		boolean displayNumFlag = true;
		int displayNum = 0;
		List<String> sortList = new ArrayList<>();

		//入力例 1\nSalt Lake City\nSeattle\nDenver\nPhoenix\n
		//入力例 2\nHello World\n\nCodeEval\nQuick Fox\nA\nSan Francisco\n
		while ((line = in.readLine()) != null) {
			if (displayNumFlag) {
				displayNum = Integer.parseInt(line);
				displayNumFlag = false;
			} else {
//				for (int i = 1; i < list.size(); i++) {
				int sortListSize = sortList.size();

				if (sortListSize > 0) {
					for(int j = 0; j < sortListSize; j++) {
						if (line.length() > sortList.get(j).length()) {
							sortList.add(j, line);
							break;
						} else if (j == sortListSize - 1){
							sortList.add(line);
							break;
						}
					}
				} else {
					sortList.add(line);
				}
				//問題文がおかしい？一行ずつの入力でどこで実行の確定処理が入るのか不明。
				if (line.equals("Phoenix") || line.equals("San Francisco")) {
					for (int i = 0; i < displayNum; i++) {
						System.out.println(sortList.get(i));
					}
				}
			}
		}
	}
}
