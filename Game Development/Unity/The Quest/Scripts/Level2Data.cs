using System.Collections;
using System.Collections.Generic;
using UnityEngine;


[System.Serializable]
public class Level2Data {

public int currentHealth;
public int currentWindCrystal;
public int currentEarthCrystal;
public int currentTokens;


public int[]   windCrystalIndices;
public int[]   earthCrystalIndices;
public int[]   enemiesIndices;
public int[]   tokensIndices;

public float[] playerPosition;
public float[,] enemy_position;




public Level2Data (Player player) {
currentHealth=player.currentHealth;
currentWindCrystal=player.currentWindCrystal;
currentEarthCrystal=player.currentEarthCrystal;
currentTokens=player.currentTokens;


windCrystalIndices=player.wind_crystals_indices;
earthCrystalIndices=player.earth_crystals_indices;
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