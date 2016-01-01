rm -rf html/dist
rm -rf html/war
gradlew html:dist
@rem to deploy to github pages
@rem switch to 'gh-pages' branch and merge with master
@http://hchan.github.io/tachyonsJourney/html/build/dist/
cp -R html/build/dist/assets/* html/build/dist/html