import 'package:flutter/material.dart';
import 'package:adobe_xd/pinned.dart';

class XDLocation1 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        Pinned.fromPins(
          Pin(start: 0.0, end: 0.0),
          Pin(start: 0.0, end: 0.0),
          child:
              // Adobe XD layer: 'Location 1' (shape)
              Container(
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(14.0),
              color: const Color(0xffffffff),
              boxShadow: [
                BoxShadow(
                  color: const Color(0x29000000),
                  offset: Offset(0, 3),
                  blurRadius: 6,
                ),
              ],
            ),
          ),
        ),
        Container(),
        Container(),
        Pinned.fromPins(
          Pin(start: 22.0, end: 22.0),
          Pin(size: 8.0, middle: 0.2813),
          child:
              // Adobe XD layer: 'Busyness Meter' (group)
              Stack(
            children: <Widget>[
              Container(),
            ],
          ),
        ),
        Pinned.fromPins(
          Pin(size: 104.0, start: 22.0),
          Pin(size: 18.0, middle: 0.3867),
          child: Text(
            'Busy - 50% Full',
            style: TextStyle(
              fontFamily: 'SF Pro',
              fontSize: 15,
              color: const Color(0xff000000),
              fontWeight: FontWeight.w600,
              height: 0.8,
            ),
            textHeightBehavior:
                TextHeightBehavior(applyHeightToFirstAscent: false),
            textAlign: TextAlign.center,
          ),
        ),
      ],
    );
  }
}
