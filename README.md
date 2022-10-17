# ComposeLoading [![](https://jitpack.io/v/commandiron/ComposeLoading.svg)](https://jitpack.io/#commandiron/ComposeLoading)


Add loading spinners in Android Jetpack Compose.

Implementation of [SpinKit](https://tobiasahlin.com/spinkit/) with additionals.

## How it looks

|Preview|
|-------|
|<img src="https://user-images.githubusercontent.com/50905347/185885360-4b7b0d26-3230-4969-8c0f-a222e9bb9730.gif" width="230" height="230">|

## Setup
1. Open the file `settings.gradle` (it looks like that)
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url 'https://jitpack.io' }
       ...
    }
} 
...
```
2. Sync the project
3. Add dependency
```groovy
dependencies {
        implementation 'com.github.commandiron:ComposeLoading:1.0.4'
}
```

## Usage

|Spinner|Usage|Spinner|Usage|
|-------|-----|-------|-----|
|<img src="https://user-images.githubusercontent.com/50905347/186412723-b2093887-da73-496a-8046-c155f6fc2834.gif" width="115" height="115">|```RotatingPlane()```|<img src="https://user-images.githubusercontent.com/50905347/186416939-a9b8d636-dd65-4f46-8739-efc22c876a08.gif" width="115" height="115">|```ChasingDots()```|
|<img src="https://user-images.githubusercontent.com/50905347/186416948-5dd65691-86d5-4bfa-a484-5121f99e52ff.gif" width="115" height="115">|```DoubleBounce()```|<img src="https://user-images.githubusercontent.com/50905347/186416952-b0382915-b420-4da1-94ad-00dc53759242.gif" width="115" height="115">|```Wave()```|
|<img src="https://user-images.githubusercontent.com/50905347/186416955-259ed853-37e0-4297-b1d1-ebf90ccb2456.gif" width="115" height="115">|```WanderingCubes()```|<img src="https://user-images.githubusercontent.com/50905347/186416960-9cc39ac6-fc1f-4e46-b896-c43a50fa1b13.gif" width="115" height="115">|```Pulse()```|
|<img src="https://user-images.githubusercontent.com/50905347/186416964-0ebfdb87-66d7-4f93-911a-fb68b4122353.gif" width="115" height="115">|```ChasingTwoDots()```|<img src="https://user-images.githubusercontent.com/50905347/186416972-4528641a-9faf-4f9b-b54a-f61598590566.gif" width="115" height="115">|```ThreeBounce()```|
|<img src="https://user-images.githubusercontent.com/50905347/185810357-9a841c3c-eb07-4d73-8c39-09a7887f9fdc.gif" width="115" height="115">|```Circle()```|<img src="https://user-images.githubusercontent.com/50905347/185810359-5ac09d83-cc35-47f2-86c8-b9419fa8ebff.gif" width="115" height="115">|```CubeGrid()```|
|<img src="https://user-images.githubusercontent.com/50905347/185810361-f95bb491-cb84-4427-bb7c-a84f3dc4a5d7.gif" width="115" height="115">|```FadingCircle()```|<img src="https://user-images.githubusercontent.com/50905347/185810362-48ff244f-d1d9-43a0-96d8-a36ecf547daa.gif" width="115" height="115">|```FoldingCube()```|
|<img src="https://user-images.githubusercontent.com/50905347/185886487-a1a240ec-6469-4371-b286-2a68f3dd419b.gif" width="115" height="115">|```InstaSpinner()```|<img src="https://user-images.githubusercontent.com/50905347/184554278-fbd17d1f-f5f3-4750-8eb7-cac7ef54f3f1.gif" width="115" height="115">|```LoadingBar()```|
|<img src="https://user-images.githubusercontent.com/50905347/184554279-298c17df-b8f4-498c-bdf5-b6f81c16ffbe.gif" width="115" height="115">|```LoadingDots()```|
