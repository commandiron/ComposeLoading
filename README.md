# ComposeLoading

Android Jetpack Compose implementation of [SpinKit](https://tobiasahlin.com/spinkit/) with additionals.

## How it looks

<table>
<tr><td><div align="center">SpinKit</div></td><td><div align="center">Loading Bar</div></td><td><div align="center">Loading Dots</div></td></tr>

<tr>
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184536631-c3d8561c-b991-4f99-b713-15e888481252.gif" width="231" height="173">
</div>
</td> 
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184497482-fe3141f7-ea3a-433c-be67-0ec8196579f9.gif" width="231" height="173">
</div>
</td> 
<td>
<div align="center">
<img src="https://user-images.githubusercontent.com/50905347/184497705-9236994c-8985-482a-81c0-5604dd0f69ca.gif" width="231" height="173">
</div>
</td>
</tr>
<tr><td><div align="center">Usage</div></td><td><div align="center">Usage</div></td><td><div align="center">Usage</div></td></tr>
<tr>
<td>
 
```kotlin  
//e.g.
RotatingPlane()
``` 
</td> 
<td>
    
```kotlin  
    
LoadingBar(fakeMillis = 10000)
``` 
</td> 
<td>
    
```kotlin  
    
LoadingDots("Loading")
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
