# Origin Records: Android APK build
1. Create a new empty GitHub repository and upload everything in this folder (keep the `.github` folder).
2. Open the repo's **Actions** tab. The "Build APK" workflow runs on every push to `main` (or click **Run workflow**).
3. When it finishes (about 5 minutes), open the run and download **origin-records-apk** from Artifacts. Unzip it and copy `app-debug.apk` to your phone.
4. On Android, open the APK and allow "Install unknown apps" if asked.

Notes: the app UI is `www/index.html`; edit it and push to rebuild. Fonts and icons load from the internet. CSV reports are shared through the Android share sheet.
