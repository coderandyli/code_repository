---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by lizhen.
--- DateTime: 2019-07-15 14:29
---
local key = "key"
local value = "10000"
local currentTime = "1563177297"

 --setnx info
local result_1 = false
if result_1 == true
then
    print("success1")
else
    local currentValue = "1563177296"
    if tonumber(currentValue) < tonumber(currentTime)
    then
        local oldValue = "1563177296"
        if oldValue == currentValue
        then
            print("success2")
        --else
        end
    --else
    end
end