# ComposeLoading [![](https://jitpack.io/v/commandiron/ComposeLoading.svg)](https://jitpack.io/#commandiron/ComposeLoading)


Android Jetpack Compose implementation of [SpinKit](https://tobiasahlin.com/spinkit/) with additionals.

## How it looks

|Preview|
|-------|
|<img src="https://user-images.githubusercontent.com/50905347/185809978-83dda286-b898-4653-975f-4b44843767f6.gif" width="230" height="230">|

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
        implementation 'com.github.commandiron:ComposeLoading:1.0'
}
```

## Usage

|Spinner|Usage|Spinner|Usage|
|-------|-----|-------|-----|
|<img src="https://user-images.githubusercontent.com/50905347/184547400-f804659d-47ab-44c0-b687-0b112b37feb6.gif" width="115" height="115">|```RotatingPlane()```|<img src="https://user-images.githubusercontent.com/50905347/184547925-717f957e-35a1-48ee-9677-971c91e876e3.gif" width="115" height="115">|```ChasingDots()```|
|<img src="https://user-images.githubusercontent.com/50905347/184548345-edcf0bd0-0b2b-44c9-aa09-d74f5ae6decf.gif" width="115" height="115">|```DoubleBounce()```|<img src="https://user-images.githubusercontent.com/50905347/184549191-5304e7ee-2bd3-486c-b062-d6b7631f210a.gif" width="115" height="115">|```Wave()```|
|<img src="https://user-images.githubusercontent.com/50905347/184549202-d88eeaba-827e-4c51-9e3a-d0d2dd483212.gif" width="115" height="115">|```WanderingCubes()```|<img src="https://user-images.githubusercontent.com/50905347/184549207-032335cb-462c-44bd-9080-0d8a960b95dd.gif" width="115" height="115">|```Pulse()```|
|<img src="https://user-images.githubusercontent.com/50905347/184549209-f5503455-6803-48f3-9db4-d0104027f411.gif" width="115" height="115">|```ChasingTwoDots()```|<img src="https://user-images.githubusercontent.com/50905347/184549212-777076df-76e8-4e0f-9251-d7c5eb0b362e.gif" width="115" height="115">|```ThreeBounce()```|
|<img src="https://user-images.githubusercontent.com/50905347/184554273-476e6cb6-e806-4bb0-adef-0fff0f136247.png" width="115" height="115">|```Circle()```|<img src="https://user-images.githubusercontent.com/50905347/184554274-c0bf19f4-3e32-4920-8f66-ae14d478e859.png" width="115" height="115">|```CubeGrid()```|
|<img src="https://user-images.githubusercontent.com/50905347/184554275-0d1bd5e7-48a7-4828-8824-3fd8cfd6cb14.png" width="115" height="115">|```FadingCircle()```|<img src="https://user-images.githubusercontent.com/50905347/184554276-e17ff715-e102-4247-be3b-9a23684f303e.png" width="115" height="115">|```FoldingCube()```|
|<img src="https://user-images.githubusercontent.com/50905347/184554277-50a2ee51-2a17-4e22-9466-ddd0fcad9832.png" width="115" height="115">|```InstaSpinner()```|<img src="https://user-images.githubusercontent.com/50905347/184554278-fbd17d1f-f5f3-4750-8eb7-cac7ef54f3f1.gif" width="115" height="115">|```LoadingBar()```|
|<img src="https://user-images.githubusercontent.com/50905347/184554279-298c17df-b8f4-498c-bdf5-b6f81c16ffbe.gif" width="115" height="115">|```LoadingDots()```|
