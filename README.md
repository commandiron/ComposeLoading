# ComposeLoading [![](https://jitpack.io/v/commandiron/ComposeLoading.svg)](https://jitpack.io/#commandiron/ComposeLoading)


Android Jetpack Compose implementation of [SpinKit](https://tobiasahlin.com/spinkit/) with additionals.

## How it looks

<table>
<tr><td><div align="center">Preview</div></td></tr>
<tr>
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184544847-1321238a-8167-4ec6-81a4-78ec9ed8421c.gif" width="230" height="230">
</div>
</td>
</tr>
</table>

<table>
<tr><td><div align="center">Spinner</div></td><td><div align="center">Usage</div></td></tr>
 
<tr>
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184544847-1321238a-8167-4ec6-81a4-78ec9ed8421c.gif" width="57.5" height="57.5">
</div>
</td>
 
<td>
 
```kotlin  
RotatingPlane()
``` 
</td>
</tr>
 
<tr>
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184544847-1321238a-8167-4ec6-81a4-78ec9ed8421c.gif" width="57.5" height="57.5">
</div>
</td>
<td>
 
```kotlin  
RotatingPlane()
``` 
</td>
</tr>
 
<tr>
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184544847-1321238a-8167-4ec6-81a4-78ec9ed8421c.gif" width="57.5" height="57.5">
</div>
</td>
<td>
 
```kotlin  
RotatingPlane()
``` 
</td>
</tr>
 
 
</table>

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
