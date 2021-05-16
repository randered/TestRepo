import java.util.Scanner;

public class HeiganDanceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerHitPoints = 18_500;
        double bossHitPoints = 3_000_000;
        int cloudDamage = 3500;
        int eruptionDamage = 6000;
        int dealDamageNextTurn = 0;

        int[][] heiganChamber = new int[15][15];

        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        float damageToBossPerTurn = Float.parseFloat(scanner.nextLine());

        while (playerHitPoints > 0 || bossHitPoints > 0) {
            if (playerHitPoints >= 0) {
                bossHitPoints -= damageToBossPerTurn;
            }
            if (lastSpell.equals("Cloud")) {
                playerHitPoints -= cloudDamage;
            }
            if (bossHitPoints <= 0 || playerHitPoints <= 0) {
                break;
            }

            String[] inputSpell = scanner.nextLine().split(" ");

            String spellName = inputSpell[0];
            int targetRow = Integer.parseInt(inputSpell[1]); // Row Coordinates of the Spell
            int targetCow = Integer.parseInt(inputSpell[2]); // Col Coordinates of the spell

            if (isInSpellArea(targetRow, targetCow, playerRow, playerCol)) {
                if (!isInSpellArea(targetRow, targetCow, playerRow - 1, playerCol)) {
                    playerRow--;
                    spellName = "";
                } else if (!isInSpellArea(targetRow, targetCow, playerRow, playerCol + 1)) {
                    playerCol++;
                    spellName = "";
                } else if (!isInSpellArea(targetRow, targetCow, playerRow + 1, playerCol)) {
                    playerRow++;
                    spellName = "";
                } else if (!isInSpellArea(targetRow, targetCow, playerRow, playerCol - 1)) {
                    playerCol--;
                    spellName = "";
                } else {
                    if (spellName.equals("Cloud")) {
                        playerHitPoints -= cloudDamage;
                        lastSpell = "Cloud";
                    } else if (spellName.equals("Eruption")) {
                        playerHitPoints -= eruptionDamage;
                        lastSpell = "Eruption";
                    }
                }
            }

        }

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String bossCondition = bossHitPoints <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f ", bossHitPoints);
        String playerCondition = playerHitPoints <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHitPoints);
        String finalPosition = String.format("Final position: %d, %d", playerRow, playerCol);
        System.out.println(bossCondition);
        System.out.println(playerCondition);
        System.out.println(finalPosition);
    }



    private static boolean isWall(int cellToMove) {
        return cellToMove < 0 || cellToMove >= 15;
    }

    private static boolean isInSpellArea(int targetRow, int targetCol, int playerRow, int playerCol) {

        if ((targetRow - 1 <= playerRow && playerRow <= targetRow + 1)
                && (targetCol - 1 <= playerCol && playerCol <= targetCol + 1)) {
            return true;
        }
        return false;
    }

}
