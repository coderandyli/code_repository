package com.coderandyli.project.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.coderandyli.project.entity.Link;
import com.coderandyli.project.mapper.LinkMapper;
import com.coderandyli.project.service.LinkService;
import org.springframework.stereotype.Service;



@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}
