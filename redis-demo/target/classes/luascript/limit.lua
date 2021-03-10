-- 控制每60秒的访问频率为5次
local times = redis.call('incr',KEYS[1])
if times == 1 then
    redis.call('expire',KEYS[1],ARGV[1])
end
if times > tonumber(ARGV[2]) then
    return 'a'
end
return 'b'

