using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using TMPro;
using UnityEngine.Audio;

public class Player : MonoBehaviour
{

    [SerializeField] AudioClip audio1;
    [SerializeField] AudioClip audio2;
    [SerializeField] AudioClip audio3;
    [SerializeField] AudioClip audio4;
    [SerializeField] AudioClip audio5;

    [SerializeField] AudioSource audioSrc;
    [SerializeField] GameObject pauseMenu;
    [SerializeField] GameObject startMenu;
    [SerializeField] GameObject SaveMenu;
    [SerializeField] GameObject YouWon;
        [SerializeField] GameObject YouWon2;
[SerializeField]  ParticleSystem Death_Particles;


    [SerializeField] AudioMixer audioMixer;

    [SerializeField] GameObject SettingsMenu;

    [SerializeField] GameObject SaveMenuQuit;

    [SerializeField] GameObject youDiedMenu;
    [SerializeField] GameObject warning;

    [SerializeField] Material waterMaterial;
    [SerializeField] Material groundMaterial;
    [SerializeField] GameObject ConfirmQuitMenu;
    [SerializeField] GameObject wall;

    [SerializeField] Material skyBoxMaterial;
    [SerializeField] Light myLight;

    [SerializeField] GameObject LoadGameObject;
    [SerializeField] GameObject timer;

    [SerializeField] GameObject[] collectibles;
    public delegate void load(GameObject myPlayer);

    public static event load OnLoad;
    RaycastHit info;
    int counterDeath = 0;
    public GameObject[] tokens;
    public GameObject camera;

    public int[] token_indices;
    public GameObject[] wind_crystals;
    public int[] wind_crystals_indices;
    public GameObject[] earth_crystals;
    public int[] earth_crystals_indices;
    public GameObject[] fire_crystals;
    public int[] fire_crystals_indices;
    public GameObject[] water_crystals;
    public int[] water_crystals_indices;
    public MeterScript waterCrystalMeter;
    public int currentWaterCrystal;
    public int currentWindCrystal;
    public int currentEarthCrystal;
    public MeterScript healthMeter;
    public int currentHealth;
    public int MaxHealth = 6;
    public MeterScript fireCrystalMeter;
    public MeterScript windCrystalMeter;
    public MeterScript earthCrystalMeter;
    GameObject[] templeRocks;
    List<int> templeRockIndex = new List<int>();
    [SerializeField] GameObject winPoint;


    public int currentfireCrystal;
    public MeterScript tokensMeter;
    public int currentTokens;
    public int maxWaterCrystal = 4;
    public int maxWindAndEarthCrystal = 2;

    public static GameObject[] enemies;
    public Vector3[] enemy_position;
    public static int[] enemies_indices;



    public TMP_Text LivesTxt;
    public GameObject[] structures;
    GameObject ground;
    Animator animator;

    void Start()
    {

        animator = GetComponent<Animator>();

        animator.SetLayerWeight(1, 0f);
        currentWaterCrystal = 0;
        currentHealth = MaxHealth;
        if (waterCrystalMeter != null & fireCrystalMeter != null)
        {
            waterCrystalMeter.SetMaxHealth(maxWaterCrystal);
            fireCrystalMeter.SetMaxHealth(maxWaterCrystal);
            waterCrystalMeter.SetHealth(0);
            fireCrystalMeter.SetHealth(0);

        }
        if (windCrystalMeter != null & earthCrystalMeter != null)
        {
            windCrystalMeter.SetMaxHealth(maxWindAndEarthCrystal);
            earthCrystalMeter.SetMaxHealth(maxWindAndEarthCrystal);
            tokensMeter.SetHealth(2);
            windCrystalMeter.SetHealth(0);
            earthCrystalMeter.SetHealth(0);

        }
        tokensMeter.SetMaxHealth(maxWaterCrystal);

        healthMeter.SetMaxHealth(MaxHealth);
        Cursor.lockState = CursorLockMode.Confined;
        Cursor.visible = true;
        enemies = GameObject.FindGameObjectsWithTag("Enemy");

        enemy_position = new Vector3[enemies.Length];
        tokens = GameObject.FindGameObjectsWithTag("token");
        water_crystals = GameObject.FindGameObjectsWithTag("water_crystal");
        fire_crystals = GameObject.FindGameObjectsWithTag("fire_crystal");
        wind_crystals = GameObject.FindGameObjectsWithTag("wind_crystal");
        earth_crystals = GameObject.FindGameObjectsWithTag("earth_crystal");
        fire_crystals_indices = new int[fire_crystals.Length];
        water_crystals_indices = new int[water_crystals.Length];
        earth_crystals_indices = new int[earth_crystals.Length];
        wind_crystals_indices = new int[wind_crystals.Length];

        enemies_indices = new int[enemies.Length];
        token_indices = new int[tokens.Length];


        for (int i = 0; i < fire_crystals.Length; i++)
        {
            fire_crystals_indices[i] = 1;
        }


        for (int i = 0; i < enemies.Length; i++)
        {
            enemies_indices[i] = 1;
        }
        for (int i = 0; i < water_crystals.Length; i++)
        {
            water_crystals_indices[i] = 1;
        }
        for (int i = 0; i < earth_crystals.Length; i++)
        {
            earth_crystals_indices[i] = 1;
        }

        for (int i = 0; i < wind_crystals.Length; i++)
        {
            wind_crystals_indices[i] = 1;
        }
        for (int i = 0; i < tokens.Length; i++)
        {
            token_indices[i] = 1;
        }


        templeRocks = GameObject.FindGameObjectsWithTag("templeRock");
        for (int i = 0; i < templeRocks.Length; i++)
        {
            templeRockIndex.Add(0);
        }
    }




    public void SetVolume(float volume)
    {
        audioMixer.SetFloat("volume", volume);
    }
    public void NewGame()
    {
        startMenu.SetActive(false);
    }



    private void GameWon()
    {
        winPoint.SetActive(true);

        Debug.Log("game wooooon");
        StartCoroutine("appear", YouWon);
        structures = GameObject.FindGameObjectsWithTag("structure");
        for (int i = 0; i < structures.Length; i++)
        {
            structures[i].GetComponent<MeshRenderer>().material = waterMaterial;
        }
        RenderSettings.skybox = skyBoxMaterial;
        myLight.intensity = 3f;
        RenderSettings.ambientIntensity = 4f;
        ground = GameObject.FindGameObjectWithTag("ground");
        ground.GetComponent<MeshRenderer>().material = groundMaterial;

    }
    private void OnTriggerEnter(Collider other)
    {



        if (other.gameObject.tag == "water_crystal")
        {


            for (int i = 0; i < water_crystals.Length; i++)
            {
                if (water_crystals[i].name == other.gameObject.name)
                {
                    water_crystals_indices[i] = 0;
                    water_crystals[i].SetActive(false);
                }
            }






            Debug.Log("hit water crystal");
            currentWaterCrystal++;
            waterCrystalMeter.SetHealth(currentWaterCrystal);
            audioSrc.PlayOneShot(audio1);
            StartCoroutine(wait(other.gameObject));

            if (currentWaterCrystal == 4 & currentfireCrystal == 4 & currentTokens == 2)
            {
                GameWon();
            }




        }
        else if (other.gameObject.tag == "wind_crystal")
        {


            for (int i = 0; i < wind_crystals.Length; i++)
            {
                if (wind_crystals[i].name == other.gameObject.name)
                {
                    wind_crystals_indices[i] = 0;
                    wind_crystals[i].SetActive(false);
                }
            }






            Debug.Log("hit wind crystal");
            currentWindCrystal++;
            windCrystalMeter.SetHealth(currentWindCrystal);
            audioSrc.PlayOneShot(audio1);
            StartCoroutine(wait(other.gameObject));


        }

          else if (other.gameObject.tag == "Enemy")
        {
            audioSrc.PlayOneShot(audio5);
            Debug.Log("hit enemy ");
                       StartCoroutine("decreaseHealth");

        }


        else if (other.gameObject.tag == "earth_crystal")
        {


            for (int i = 0; i < earth_crystals.Length; i++)
            {
                if (earth_crystals[i].name == other.gameObject.name)
                {
                    earth_crystals_indices[i] = 0;
                    Debug.Log("hit earth crystal");
                    currentEarthCrystal++;
                    Debug.Log(currentEarthCrystal);

                    earthCrystalMeter.SetHealth(currentEarthCrystal);
                    audioSrc.PlayOneShot(audio1);
                    earth_crystals[i].SetActive(false);
                }
            }







            StartCoroutine(wait(other.gameObject));


        }
        else if (other.gameObject.tag == "token")
        {


            for (int i = 0; i < tokens.Length; i++)
            {
                if (tokens[i].name == other.gameObject.name)
                {
                    token_indices[i] = 0;
                    tokens[i].SetActive(false);
                }
            }






            Debug.Log("took token");
            currentTokens++;
            Debug.Log(currentTokens);

            tokensMeter.SetHealth(currentTokens);
            audioSrc.PlayOneShot(audio1);
            StartCoroutine(wait(other.gameObject));
            if (currentWaterCrystal == 4 & currentfireCrystal == 4 & currentTokens == 2)
            {
                GameWon();
            }

        }

        else if (other.gameObject.tag == "FinalWinPoint")
        {
            this.gameObject.SetActive(false);
            this.transform.position = new Vector3(11.53018f, 11.5733f, -775.5334f);
            this.transform.Rotate(0.0f, -94.177f, 0.0f);
            this.gameObject.SetActive(true);
            camera.gameObject.SetActive(true);
            audioSrc.PlayOneShot(audio3);
            StartCoroutine("appear2");

        }

        else if (other.gameObject.tag == "fire_crystal")
        {




            Debug.Log("hit fire crystal");
            currentfireCrystal++;
            fireCrystalMeter.SetHealth(currentfireCrystal);

            for (int i = 0; i < fire_crystals.Length; i++)
            {
                if (fire_crystals[i].name == other.gameObject.name)
                {

                    Debug.Log("fiiiire");
                    fire_crystals_indices[i] = 0;
                    fire_crystals[i].SetActive(false);
                }
            }


            audioSrc.PlayOneShot(audio1);
            StartCoroutine(wait(other.gameObject));
            if (currentWaterCrystal == 4 & currentfireCrystal == 4 & currentTokens == 2)
            {
                GameWon();
            }


        }



        else if (other.gameObject.tag == "Fire")
        {

            Debug.Log("hit fire ");

            audioSrc.PlayOneShot(audio2);
            audioSrc.PlayOneShot(audio3);
            StartCoroutine("decreaseHealth");


        }
        else if
     (other.gameObject.tag == "checkpoint")
        {
            SaveSystem.SaveLevel(this);
        }


    }

    private void OnTriggerExit(Collider other)
    {
        if (other.gameObject.tag == "Fire")
        {
            StopCoroutine("decreaseHealth");

        }

    }
    private void OnCollisionEnter(Collision other)
    {

        if (other.gameObject.tag == "ground")
        {


            Debug.Log("hit ground ");
            StartCoroutine("decreaseHealth");
        }


     


        if (other.gameObject.tag == "WinPoint")
        {
            SceneManager.LoadScene("level2");
        }






    }

    private void OnCollisionExit(Collision other)
    {
        if (other.gameObject.tag == "ground")
        {


            Debug.Log("hit ground ");
            StopCoroutine("decreaseHealth");
        }
    }



    IEnumerator decreaseHealth()
    {

        while (currentHealth > 0)
        {
            yield return new WaitForSeconds(1);
            currentHealth--;
            healthMeter.SetHealth(currentHealth);

        }
        if (currentHealth == 0)
        {

            counterDeath++;
            if (counterDeath < 3)
            {
                LivesTxt.SetText("Lives left: " + (3 - counterDeath));
                Debug.Log("hiiii");
                animator.SetLayerWeight(1, 0f);
                this.gameObject.SetActive(false);
                timer.SetActive(true);
                LoadGameObject.SetActive(true);
                if (OnLoad != null)
                {
                    Debug.Log("yara");
                    OnLoad(this.gameObject);
                }

            }

            else
            {
                youDiedMenu.SetActive(true);
            }
        }
    }

    public void SaveLevel()
    {

        for (int i = 0; i < enemies.Length; i++)
        {
            enemy_position[i] = enemies[i].transform.position;
        }

        for (int i = 0; i < enemies.Length; i++)
        {
            if (enemies_indices[i] == 0)
            {
                Debug.Log("wilililish");
            }
        }

        SaveSystem.SaveLevel(this);
    }





    public void SaveLevel2()
    {

        for (int i = 0; i < enemies.Length; i++)
        {
            enemy_position[i] = enemies[i].transform.position;
        }

        for (int i = 0; i < enemies.Length; i++)
        {
            if (enemies_indices[i] == 0)
            {
                Debug.Log("wilililish");
            }
        }

        SaveSystem2.SaveLevel2(this);
    }

    public void loadLevel()
    {

        startMenu.SetActive(false);

        LevelData data = SaveSystem.LoadLevel();







        for (int i = 0; i < enemies.Length; i++)
        {
            if (data.enemiesIndices[i] == 1)
            {

                Vector3 eenemy_position;
                eenemy_position.x = data.enemy_position[i, 0];
                eenemy_position.y = data.enemy_position[i, 1];
                eenemy_position.z = data.enemy_position[i, 2];

                enemies[i].gameObject.SetActive(false);
                enemies[i].transform.position = eenemy_position;
                enemies[i].gameObject.SetActive(true);
            }
            else
            {
                enemies[i].gameObject.SetActive(false);

            }

        }
        currentHealth = data.currentHealth;
        currentfireCrystal = data.currentFireCrystal;
        currentWaterCrystal = data.currentWaterCrystal;
        currentTokens = data.currentTokens;

        healthMeter.SetHealth(currentHealth);
        fireCrystalMeter.SetHealth(currentfireCrystal);
        waterCrystalMeter.SetHealth(currentWaterCrystal);
        tokensMeter.SetHealth(currentTokens);




        token_indices = data.tokensIndices;
        for (int i = 0; i < tokens.Length; i++)
        {
            if (token_indices[i] == 0)
            {
                tokens[i].SetActive(false);
            }
        }



        water_crystals_indices = data.waterCrystalIndices;
        for (int i = 0; i < water_crystals.Length; i++)
        {
            if (water_crystals_indices[i] == 0)
            {
                water_crystals[i].SetActive(false);
            }
        }
        fire_crystals_indices = data.fireCrystalIndices;
        for (int i = 0; i < fire_crystals.Length; i++)
        {
            if (fire_crystals_indices[i] == 0)
            {
                fire_crystals[i].SetActive(false);
            }
        }


        Vector3 position;

        position.x = data.playerPosition[0];
        position.y = data.playerPosition[1];
        position.z = data.playerPosition[2];




        this.gameObject.SetActive(false);
        this.gameObject.transform.position = position;
        this.gameObject.SetActive(true);
        animator.SetLayerWeight(1, 0f);





    }

    public void loadLevel12()
    {

        startMenu.SetActive(false);

        LevelData data = SaveSystem.LoadLevel();







        for (int i = 0; i < enemies.Length; i++)
        {
            if (data.enemiesIndices[i] == 1)
            {

                Vector3 eenemy_position;
                eenemy_position.x = data.enemy_position[i, 0];
                eenemy_position.y = data.enemy_position[i, 1];
                eenemy_position.z = data.enemy_position[i, 2];

                enemies[i].gameObject.SetActive(false);
                enemies[i].transform.position = eenemy_position;
                enemies[i].gameObject.SetActive(true);
            }
            else
            {
                enemies[i].gameObject.SetActive(false);

            }

        }
        currentHealth = data.currentHealth;
        currentfireCrystal = data.currentFireCrystal;
        currentWaterCrystal = data.currentWaterCrystal;
        currentTokens = data.currentTokens;

        healthMeter.SetHealth(currentHealth);
        fireCrystalMeter.SetHealth(currentfireCrystal);
        waterCrystalMeter.SetHealth(currentWaterCrystal);
        tokensMeter.SetHealth(currentTokens);




        token_indices = data.tokensIndices;
        for (int i = 0; i < tokens.Length; i++)
        {
            if (token_indices[i] == 0)
            {
                tokens[i].SetActive(false);
            }
        }



        water_crystals_indices = data.waterCrystalIndices;
        for (int i = 0; i < water_crystals.Length; i++)
        {
            if (water_crystals_indices[i] == 0)
            {
                water_crystals[i].SetActive(false);
            }
        }
        fire_crystals_indices = data.fireCrystalIndices;
        for (int i = 0; i < fire_crystals.Length; i++)
        {
            if (fire_crystals_indices[i] == 0)
            {
                fire_crystals[i].SetActive(false);
            }
        }


        Vector3 position;

        position.x = data.playerPosition[0];
        position.y = data.playerPosition[1];
        position.z = data.playerPosition[2];




        this.gameObject.transform.position = position;
        animator.SetLayerWeight(1, 0f);





    }


    public void loadLevel2()
    {

        startMenu.SetActive(false);

        Level2Data data = SaveSystem2.LoadLevel2();





















        currentHealth = data.currentHealth;
        currentWindCrystal = data.currentWindCrystal;
        currentEarthCrystal = data.currentEarthCrystal;
        currentTokens = data.currentTokens;

        healthMeter.SetHealth(currentHealth);
        windCrystalMeter.SetHealth(currentWindCrystal);
        earthCrystalMeter.SetHealth(currentEarthCrystal);
        tokensMeter.SetHealth(currentTokens);




        token_indices = data.tokensIndices;
        for (int i = 0; i < tokens.Length; i++)
        {
            if (token_indices[i] == 0)
            {
                tokens[i].SetActive(false);
            }
        }



        wind_crystals_indices = data.windCrystalIndices;
        for (int i = 0; i < wind_crystals.Length; i++)
        {
            if (wind_crystals_indices[i] == 0)
            {
                wind_crystals[i].SetActive(false);
            }
        }
        earth_crystals_indices = data.earthCrystalIndices;
        for (int i = 0; i < earth_crystals.Length; i++)
        {
            if (earth_crystals_indices[i] == 0)
            {
                earth_crystals[i].SetActive(false);
            }
        }


        Vector3 position;

        position.x = data.playerPosition[0];
        position.y = data.playerPosition[1];
        position.z = data.playerPosition[2];




        this.gameObject.SetActive(false);
        this.gameObject.transform.position = position;
        this.gameObject.SetActive(true);
        animator.SetLayerWeight(1, 0f);





    }



    public void QuitRequest()
    {

        pauseMenu.SetActive(false);
        Debug.Log("quit request");

        ConfirmQuitMenu.SetActive(true);
        Debug.Log("quit request");

    }


    public void ConfirmSaveAndResume()
    {
        SaveSystem.SaveLevel(this);
        SaveMenu.gameObject.SetActive(false);
        pauseMenu.gameObject.SetActive(false);
        Time.timeScale = 1;



    }

    public void ConfirmSaveAndResume2()
    {
        SaveSystem2.SaveLevel2(this);
        SaveMenu.gameObject.SetActive(false);
        pauseMenu.gameObject.SetActive(false);
        Time.timeScale = 1;



    }
    public void BackToQuit()
    {
        SaveMenuQuit.gameObject.SetActive(false);

    }


    public void BackToMenu()
    {
        SaveMenu.gameObject.SetActive(false);
        pauseMenu.SetActive(true);


    }
    public void OpenSaveMenu()
    {

        pauseMenu.SetActive(false);

        SaveMenu.SetActive(true);
    }

    public void OpenSaveQuitMenu()
    {
        SaveMenuQuit.SetActive(true);
    }
    public void ConfirmQuitAndSave()
    {
        SaveSystem.SaveLevel(this);
        Application.Quit();

    }

    public void ConfirmQuitAndSave2()
    {
        Debug.Log("3");
        SaveSystem2.SaveLevel2(this);
        Debug.Log("2");

        Debug.Log("1");
    }



    public void NoQuitAndReturn()
    {
        ConfirmQuitMenu.SetActive(false);
        pauseMenu.SetActive(true);

    }


    public void settingsToMenu()
    {
        SettingsMenu.SetActive(false);
        pauseMenu.SetActive(true);

    }


    public void openSettings()
    {
        pauseMenu.SetActive(false);

        SettingsMenu.SetActive(true);
    }



    IEnumerator wait(GameObject object1)
    {
        yield return new WaitForSeconds(2);
        object1.SetActive(false);

    }
    void Update()
    {


        if (Input.GetKeyUp(KeyCode.P))
        {

            Time.timeScale = 0;
            pauseMenu.SetActive(true);
        }

        if (Input.GetKeyUp(KeyCode.R))
        {

            Time.timeScale = 1;
            pauseMenu.SetActive(false);
        }


        if (Input.GetButtonDown("Fire1"))
        {
            audioSrc.PlayOneShot(audio1);

            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if (Physics.Raycast(ray, out info))
            {

                if (info.collider.gameObject.tag == "templeRock")
                {
                    if (currentEarthCrystal == 2 && currentWindCrystal == 2 && currentTokens == 4)
                    {

                        for (int i = 0; i < templeRocks.Length; i++)
                        {


                            if (templeRocks[i] == info.collider.gameObject && templeRockIndex[i] == 0)
                            {


                                bool found = false;
                                GameObject obj = Instantiate(collectibles[i], info.point, Quaternion.identity) as GameObject;

                                templeRockIndex[i] = 1;

                                for (int j = 0; j < templeRocks.Length; j++)
                                {
                                    if (templeRockIndex[j] == 0)
                                    {
                                        found = true;
                                    }
                                }
                                if (found == false)
                                {
                                    wall.gameObject.GetComponent<Animation>().Play();

                                }




                            }
                        }
                    }
                    else
                    {
                        StartCoroutine("appear", warning);
                    }

                }
            }
            
                if (info.collider.gameObject.tag == "Enemy"){
                                                        audioSrc.PlayOneShot(audio4);
                    Instantiate(Death_Particles,info.point, Quaternion.Euler(270, 0, 0));

                    info.collider.gameObject.SetActive(false);
                }
        }

    }


    IEnumerator appear(GameObject ui)
    {
        ui.SetActive(true);
        yield return new WaitForSeconds(2);
        ui.SetActive(false);
    }

   IEnumerator appear2()
    {
        yield return new WaitForSeconds(3);
        YouWon2.SetActive(true);
    }

    public void Quit()
    {
        Application.Quit();
    }


    public void PlayAgain()
    {
        SceneManager.LoadScene("level1");

    }

    public void setQuality(int qualityIndex) {
        QualitySettings.SetQualityLevel(qualityIndex);
    }


public void SetFullScreen(bool isFullScreen){
    Screen.fullScreen=isFullScreen;
}
}
