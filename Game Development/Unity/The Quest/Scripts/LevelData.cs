using System.Collections;
using System.Collections.Generic;
using UnityEngine;


[System.Serializable]
public class LevelData {

public int currentHealth;
public int currentFireCrystal;
public int currentWaterCrystal;
public int currentTokens;


public int[]   waterCrystalIndices;
public int[]   fireCrystalIndices;
public int[]   enemiesIndices;
public int[]   tokensIndices;

public float[] playerPosition;
public float[,] enemy_position;




public LevelData (Player player) {
currentHealth=player.currentHealth;
currentFireCrystal=player.currentfireCrystal;
currentWaterCrystal=player.currentWaterCrystal;
currentTokens=player.currentTokens;


waterCrystalIndices=player.water_crystals_indices;
fireCrystalIndices=player.fire_crystals_indices;
 tokensIndices=player.token_indices;

enemiesIndices=Player.enemies_indices;


enemy_position= new float[player.enemy_position.Length,3];
for (int i=0; i <player.enemy_position.Length;i++){
    enemy_position[i,0]=player.enemy_position[i].x;
    enemy_position[i,1]=player.enemy_position[i].y;
    enemy_position[i,2]=player.enemy_position[i].z;


}


playerPosition= new float[3];
playerPosition[0]=player.transform.position.x;
playerPosition[1]=player.transform.position.y;
playerPosition[2]=player.transform.position.z;

}
}