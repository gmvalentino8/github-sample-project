#ref: https://techlife.cookpad.com/entry/2017/06/28/190000
github.dismiss_out_of_range_messages

# Check for Big PR
warn("Big PR") if git.lines_of_code > 500

# Check mergeable status
can_merge = github.pr_json["mergeable"]
warn("This PR cannot be merged yet.", sticky: false) unless can_merge

# danger-android_lint
# ref: https://github.com/loadsmart/danger-android_lint
android_lint.skip_gradle_task = true
android_lint.filtering = true

Dir.glob("**/lint-results.xml") do |file|
  android_lint.report_file = file
  android_lint.lint(inline_mode: true)
end

# danger-checkstyle_format
# ref: https://github.com/noboru-i/danger-checkstyle_format
checkstyle_format.base_path = Dir.pwd

Dir.glob("**/ktlint/*.xml") do |file|
  checkstyle_format.report file
end

if status_report[:warnings].empty?
  markdown("No lint issues were reported")
else
  markdown("No error was reported but at least one warning was found.")
end